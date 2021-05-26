function validCompanyName(e){
	key=e.keycode || e.which;
	dataEntered= String.fromCharCode(key);
	RegExp="ABCDEFGHIJKLMNÑOPQRSTUVWXYZÁÉÍÓÚabcdefghijklmnñopqrstuvwxyzáéíóú0123456789., ";
	specialKeys="8-37-38-46-164";
	specialKeyEntered=false
	for (var i in specialKeys){
		if(key==specialKeys[i]){
			specialKeyEntered=true;break;
		}
	}
	if (RegExp.indexOf(dataEntered)==-1 && !specialKeyEntered){
		return false;
	}
}


function validNumbersLetters(e){
	key=e.keycode || e.which;
	dataEntered= String.fromCharCode(key);
	RegExp="ABCDEFGHIJKLMNÑOPQRSTUVWXYZÁÉÍÓÚabcdefghijklmnñopqrstuvwxyzáéíóú0123456789 ";
	specialKeys="8-37-38-46-164";
	specialKeyEntered=false
	for (var i in specialKeys){
		if(key==specialKeys[i]){
			specialKeyEntered=true;break;
		}
	}
	if (RegExp.indexOf(dataEntered)==-1 && !specialKeyEntered){
		return false;
	}
}

function validOnlyLetters(e){
	key=e.keycode || e.which;
	dataEntered= String.fromCharCode(key);
	RegExp="ABCDEFGHIJKLMNÑOPQRSTUVWXYZÁÉÍÓÚabcdefghijklmnñopqrstuvwxyzáéíóú ";
	specialKeys="8-37-38-46-164";
	specialKeyEntered=false
	for (var i in specialKeys){
		if(key==specialKeys[i]){
			specialKeyEntered=true;break;
		}
	}
	if (RegExp.indexOf(dataEntered)==-1 && !specialKeyEntered){
		return false;
	}
}

function validOnlyNumbers(e){
	key=e.keycode || e.which;
	dataEntered= String.fromCharCode(key);
	RegExp="0123456789";
	specialKeys="8-37-38-46-164";
	specialKeyEntered=false
	for (var i in specialKeys){
		if(key==specialKeys[i]){
			specialKeyEntered=true;break;
		}
	}
	if (RegExp.indexOf(dataEntered)==-1 && !specialKeyEntered){
		return false;
	}
}

function rfcValid(rfc, allowRFCGeneric = true) {
    const rfcRegExp       = /^([A-ZÑ&]{3,4}) ?(?:- ?)?(\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\d|3[01])) ?(?:- ?)?([A-Z\d]{2})([A\d])$/;
    var   rfcValited = rfc.match(rfcRegExp);

    if (!rfcValited)  
        return false;

    const checkDigit = rfcValited.pop(),
    	  rfcWithoutDigit      = rfcValited.slice(1).join(''),
          len               = rfcWithoutDigit.length,

          dictionary       = "0123456789ABCDEFGHIJKLMN&OPQRSTUVWXYZ Ñ",
          index            = len + 1;
    var   sum,
          expectedDigit;

    if (len == 12) sum = 0
    else sum = 481; 

    for(var i=0; i<len; i++)
        sum += dictionary.indexOf(rfcWithoutDigit.charAt(i)) * (index - i);
    expectedDigit = 11 - sum % 11;
    if (expectedDigit == 11) expectedDigit = 0;
    else if (expectedDigit == 10) expectedDigit = "A";

    if ((checkDigit != expectedDigit)
     && (!allowRFCGeneric || rfcWithoutDigit + checkDigit != "XAXX010101000"))
        return false;
    else if (!allowRFCGeneric && rfcWithoutDigit + checkDigit == "XEXX010101000")
        return false;
    return rfcWithoutDigit + checkDigit;
}


function validRFCInput(input) {
    var rfc         = input.value.trim().toUpperCase(),
    	lengthRFC   = input.value.length,
        result      = document.getElementById("result"),
        companyRFCStyle      = document.getElementById("company_rfc"),
        valido;
        
    var rfcCorrect = rfcValid(rfc);
   
   
	   if (rfcCorrect) {
		   result.style.visibility = "hidden";
		   companyRFCStyle.style.color = "black";
	   }else{
		   companyRFCStyle.style.color = "red",
		   valid = "No válido"
		   result.classList.remove("ok");
		   result.style.color = "red";
		   result.innerText = "Formato de RFC: " + valid;  
	   
	    }
	        
 

    

           
    
}


