<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Relatório de Exame Realizado</title>

</head>
<body>
<div class="container mt-4">
    <h1>Relatório de Exame Realizado</h1>
    <form action="seu_action_de_busca" method="post">
        <div class="form-group">
            <label for="funcionario">Funcionário:</label>
            <s:select list="funcionarios" headerKey="" headerValue="-- Selecione --" name="funcionario" />
        </div>
        <div class="form-group">
            <label for="exame">Exame:</label>
            <s:select list="exames" headerKey="" headerValue="-- Selecione --" name="exame" />
        </div>
        <button type="submit" class="btn btn-primary">Buscar</button>
    </form>
    <hr>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Funcionário</th>
            <th>Exame</th>
            <th>Data de Realização</th>
        </tr>
        </thead>
        <tbody>

        <s:iterator value="examesRealizados">
            <tr>
                <td><s:property value="funcionario.nmFuncionario" /></td>
                <td><s:property value="exame.nmExame" /></td>
                <td><s:property value="dtRealizacao" /></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>

</body>
</html>
