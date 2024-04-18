<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Employe Creation</title>
</head>
<body >
<header>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg bg-body">
    <div class="container-fluid">
      <div class="collapse navbar-collapse" id="navbarExample01">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item active">
            <h1>Employe Creation</h1>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- Navbar -->
</header>
<main>
  <form action="saveEmploye" method="post">
    <div class="row mb-4">
      <div class="col">
        <div data-mdb-input-init class="form-outline">
          <label class="form-label" for="nom">Nom</label>
          <input type="text" id="nom" name="nom" class="form-control" />

        </div>
      </div>
      <div class="col">
        <div data-mdb-input-init class="form-outline">
          <label class="form-label" for="prenom">Prenom</label>
          <input type="text" id="prenom" name="prenom" class="form-control" />

        </div>
      </div>
    </div>

    <!-- Text input -->
    <div data-mdb-input-init class="form-outline mb-4">
      <label class="form-label" for="poste">Poste</label>
      <input type="text" id="poste" name="poste" class="form-control" />

    </div>
    <div data-mdb-input-init class="form-outline mb-4">
      <label class="form-label" for="departement">Departement</label>
      <input type="text" id="departement" name="departement" class="form-control" />

    </div>

    <div class="md-form col-md-6">
      <label for="dateEmbauche" class="form-label">Date Embauche</label>
      <input type="date" id="dateEmbauche" name="dateJsp" value="${now}" class="form-control datepicker">
    </div>

    <input data-mdb-ripple-init type="submit" value="Save" class="btn btn-secondary btn-floating mx-1">
  </form>
  ${messageJsp}
</main>
<!-- Footer -->
<footer class="text-center text-lg-start bg-body-tertiary text-muted">
  <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
    <a class="text-reset fw-bold" href="employeList">Employes List</a>
  </div>
</footer>
<!-- Footer -->

</body>
</html>