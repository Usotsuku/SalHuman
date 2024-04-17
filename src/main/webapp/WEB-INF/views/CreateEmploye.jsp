<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Employe Creation</title>
</head>
<body>
<header>
  <h1>Employe Creation</h1>
</header>
<main>
  <form action="saveEmploye" method="post">
    <div>
      <label for="nom">Nom : </label>
      <input type="text" id="nom" name="nom">
    </div>
    <div>
      <label for="prenom">Prenom : </label>
      <input type="text" id="prenom" name="prenom">
    </div>
    <div>
      <label for="departement">Departement : </label>
      <input type="text" id="departement" name="departement">
    </div>
    <div>
      <label for="poste">Poste : </label>
      <input type="text" id="poste" name="poste">
    </div>
    <div>
      <label for="dateEmbauche">Date Embauche : </label>
      <input type="date" id="dateEmbauche" name="dateJsp" value="${now}">
    </div>
    <div>
      <input type="submit" value="Save">
    </div>
  </form>
  ${messageJsp}
</main>
<footer>
  <a href="employeList">Employes List</a>
</footer>
</body>
</html>