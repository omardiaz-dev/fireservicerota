function onLoadState() {	
	load_state()
}

function onLoadEmployeeDataList() {
	load_employee_data_list() 
}

function load_state() {
 var arrayState = ["Aguascalientes","Baja California","Baja California Sur","Campeche","Chiapas","Chihuahua","Coahuila de Zaragoza","Colima","Durango","Estado de México","Guanajuato",
			  "Guerrero","Hidalgo","Jalisco","Michoacán de Ocampo","Morelos","Nayarit","Nuevo León","Oaxaca","Puebla","Querétaro","Quintana Roo","San Luis Potosí","Sinaloa","Sonora",
			  "Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas"];
 arrayState.sort();

 addStates("states", arrayState);
}

function addStates(domElement, arrayState) {
 var select = document.getElementsByName(domElement)[0];

 for (value in arrayState) {
  var option = document.createElement("option");
  option.text = arrayState[value];
  select.add(option);
 }
}

function addBloodType(domElement, arrayBloodType) {
 var select = document.getElementsByName(domElement)[0];

 for (value in arrayBloodType) {
  var option = document.createElement("option");
  option.text = arrayBloodType[value];
  select.add(option);
 }
}

function addStatus(domElement, arrayBloodType) {
 var select = document.getElementsByName(domElement)[0];

 for (value in arrayBloodType) {
  var option = document.createElement("option");
  option.text = arrayBloodType[value];
  select.add(option);
 }
}

function addBrigadistType(domElement, arrayBloodType) {
 var select = document.getElementsByName(domElement)[0];

 for (value in arrayBloodType) {
  var option = document.createElement("option");
  option.text = arrayBloodType[value];
  select.add(option);
 }
}