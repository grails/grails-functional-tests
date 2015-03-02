<!DOCTYPE html>
<html>
<head>
    <title>File upload</title>
</head>
<body>
    ${flash.message}
    <form id="myForm" action="/upload/upload" method="POST" enctype="multipart/form-data">
        <input type="file" name="myFile" />
        <input type="submit" name="submit"/>
    </form>
</body>
</html>
