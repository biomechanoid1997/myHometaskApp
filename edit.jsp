<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit pet</title>
</head>
<body>
<h3>Edit pet</h3>
<form method="post">
<input type="hidden" value="${animal.id}" name="id" />
<label>Animal Name</label><br>
<input name="AnimalName" value="${animal.animalName}"><br><br>
<label>AnimalType</label><br>
<select name="AnimalType" size="1" value="${animal.animalType}">
<option value ="Cat">Cat</option>
<option value ="Dog">Dog</option>
<option value ="Mouse">Mouse</option>
<option value ="Squirrel">Squirrel</option>
<option value ="Hamster">Hamster</option>
<option value ="Parrot">Parrot</option>
<option value ="Rabbit">Rabbit</option>
</select><br>
<label>AnimalColor</label><br>
<input name="AnimalColor" value="${animal.animalColor}"><br><br>
<label>AnimalAge</label><br>
<input name="AnimalAge" type="number" value="${animal.animalAge}" /><br><br>
<label>AnimalHost</label><br>
<input name="AnimalHost" value="${animal.animalHost}"><br><br>
<input type="submit" value="Save" />
</form>
</body>
</html>