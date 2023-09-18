<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Create pet</title>
</head>
<body>
<h3>New pet</h3>
<form method="post">
<label>Animal Name</label><br>
<input name="AnimalName"><br><br>
<label>AnimalType</label><br>
<select name="AnimalType" size="1">
<option value ="Cat">Cat</option>
<option value ="Dog">Dog</option>
<option value ="Mouse">Mouse</option>
<option value ="Squirrel">Squirrel</option>
<option value ="Teapot">Teapot</option>
<option value ="Hamster">Hamster</option>
<option value ="Parrot">Parrot</option>
<option value ="Rabbit">Rabbit</option>
</select><br>
<label>AnimalColor</label><br>
<input name="AnimalColor" ><br><br>
<label>AnimalAge</label><br>
<input name="AnimalAge" type="number" /><br><br>
<label>AnimalHost</label><br>
<input name="AnimalHost"><br><br>
<input type="submit" value="Save" />
</form>
</body>
</html>