<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Relatório de Exame Realizado</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Relatório de Exame Realizado</h1>
    <form action="exameRealizado_search" method="post">
        <div class="form-group">
            <label for="startDate">Data Inicial:</label>
            <input type="date" class="form-control" id="startDate" name="startDate" required>
        </div>
        <div class="form-group">
            <label for="endDate">Data Final:</label>
            <input type="date" class="form-control" id="endDate" name="endDate" required>
        </div>
        <button type="submit" class="btn btn-primary">Buscar</button>
    </form>
    <hr>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Código Funcionário</th>
            <th>Nome Funcionário</th>
            <th>Código Exame</th>
            <th>Nome Exame</th>
            <th>Data Realização</th>
        </tr>
        </thead>
        <tbody>

        <s:iterator value="examesRealizados">
            <tr>
                <td><s:property value="cdFuncionario" /></td>
                <td><s:property value="nmFuncionario" /></td>
                <td><s:property value="cdExame" /></td>
                <td><s:property value="nmExame" /></td>
                <td><s:property value="dtRealizacao" /></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
