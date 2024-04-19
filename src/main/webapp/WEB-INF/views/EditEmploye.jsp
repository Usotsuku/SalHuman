<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.2/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Edition</title>
</head>
<body>
<header>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg bg-body">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarExample01">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item active">
                        <h1>Employee Edition</h1>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Navbar -->
</header>
<main>
    <form action="updateEmploye" method="post">
        <div class="row mb-4">
            <div class="col">
                <div class="form-outline">
                    <label class="form-label" for="employeId">ID</label>
                    <input type="text" id="employeId" name="employeId" class="form-control" value="${employeView.employeId}" />
                </div>
                <div class="form-outline">
                    <label class="form-label" for="nom">Nom</label>
                    <input type="text" id="nom" name="nom" class="form-control" value="${employeView.nom}" />
                </div>
            </div>
            <div class="col">
                <div class="form-outline">
                    <label class="form-label" for="prenom">Prenom</label>
                    <input type="text" id="prenom" name="prenom" class="form-control" value="${employeView.prenom}" />
                </div>
            </div>
        </div>

        <!-- Text input -->
        <div class="form-outline mb-4">
            <label class="form-label" for="poste">Poste</label>
            <input type="text" id="poste" name="poste" class="form-control" value="${employeView.poste}" />
        </div>
        <div class="form-outline mb-4">
            <label class="form-label" for="departement">Departement</label>
            <input type="text" id="departement" name="departement" class="form-control" value="${employeView.departement}" />
        </div>

        <div class="md-form col-md-6">
            <label for="dateEmbauche" class="form-label">Date Embauche</label>
            <input type="date" id="dateEmbauche" name="dateJsp" value="${employeView.date_embauche}" class="form-control datepicker">
        </div>


        <input type="submit" value="Update" class="btn btn-secondary btn-floating mx-1">
    </form>
    ${messageJsp}
</main>
<!-- Footer -->
<footer class="text-center text-lg-start bg-body-tertiary text-muted">
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
        <a class="text-reset fw-bold" href="employeList">Employees List</a>
    </div>
</footer>
<!-- Footer -->
</body>
</html>
