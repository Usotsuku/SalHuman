package com.example.salhumans.services;

import com.example.salhumans.models.Element_Salaire;
import com.example.salhumans.models.Employe;
import com.example.salhumans.models.Fiche_Paie;
import com.example.salhumans.models.Heure_Travaille;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Fiche_PaieServiceImp implements Fiche_PaieService {

    @Override
    public void CalculerSalaire(Employe employe) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endDate = calendar.getTime();

        List<Heure_Travaille> heuresTravaillees = employe.getHeures_Travailles();

        int totalHoursWorked = 0;
        for (Heure_Travaille heureTravaille : heuresTravaillees) {
            Date heureTravailleDate = heureTravaille.getDate();
            if (heureTravailleDate.after(startDate) && heureTravailleDate.before(endDate)) {
                totalHoursWorked += heureTravaille.getNb_heures();
            }
        }

        float salary_brut = totalHoursWorked * 100;

        float amo = salary_brut * 0.0185f; // AMO: 1.85%
        float cnss = salary_brut * 0.0452f; // CNSS: 4.52%
        float impot = 0;

        if (salary_brut > 18000) {
            impot = salary_brut * 0.38f; // 38% if salary > 180000
        } else if (salary_brut > 8000) {
            impot = salary_brut * 0.30f; // 30% if salary > 80000
        } else if (salary_brut > 6000) {
            impot = salary_brut * 0.20f; // 20% if salary > 60000
        } else if (salary_brut > 3000) {
            impot = salary_brut * 0.10f; // 10% if salary > 30000
        }

        float netSalary = salary_brut - amo - cnss - impot;

        Fiche_Paie fiche = new Fiche_Paie();
        fiche.setPeriode(getMonthAsString(calendar.get(Calendar.MONTH)) + " " + calendar.get(Calendar.YEAR));
        fiche.setMontant_brut(salary_brut);
        fiche.setMontant_net(netSalary);
        fiche.setAmo(amo);
        fiche.setCnss(cnss);
        fiche.setImpotSurRevenu(impot);

        employe.getFiches().add(fiche);

        int currentMonth = calendar.get(Calendar.MONTH);
        if (currentMonth % 3 == 0) {
            Element_Salaire prime = new Element_Salaire();
            prime.setType("Prime");
            prime.setMontant(1000); // Assuming the bonus amount is always 1000 DH
            prime.setFiche_paie(fiche);
            fiche.getElements_Salaires().add(prime);
        }
    }

    private String getMonthAsString(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[month];
    }
}
