<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search for Customer</title>
</head>
<body>

<form method="post" action="searchCustomer">

    <label for="id">Insert id</label>
    <input id="id" name="id" type="number" min="0" required>
    <br />

    <button type="submit">Search</button>

</form>

</body>
</html>