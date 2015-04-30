
   /*$RCSfile: validateFloatRange.js,v $ $Revision: 1.9 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * Check to see if fields are in a valid float range.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateFloatRange(form) {
        var isValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name"); 

        oRange = eval('new ' + formName.value + '_floatRange()');
        for (x in oRange) {
            var field = form[oRange[x][0]];
            
            if ((field.type == 'hidden' ||
                field.type == 'text' || field.type == 'textarea') &&
                (field.value.length > 0)  &&
                 field.disabled == false) {
        
                var fMin = parseFloat(oRange[x][2]("min"));
                var fMax = parseFloat(oRange[x][2]("max"));
                var fValue = parseFloat(field.value);
                if (!(fValue >= fMin && fValue <= fMax)) {
                    if (i == 0) {
                        focusField = field;
                    }
                    fields[i++] = oRange[x][1];
                    isValid = false;
                }
            }
        }
        if (fields.length > 0) {
            focusField.focus();
            alert(fields.join('\n'));
        }
        return isValid;
    }

    /*$RCSfile: validateUtilities.js,v $ $Revision: 1.2 $ $Date: 2004/03/28 16:53:21 $ */

  /**
  * This is a place holder for common utilities used across the javascript validation
  *
  **/


    /*$RCSfile: validateByte.js,v $ $Revision: 1.9 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * Check to see if fields are a valid byte.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateByte(form) {
        var bValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name"); 
        oByte = eval('new ' + formName.value + '_ByteValidations()');

        for (x in oByte) {
            var field = form[oByte[x][0]];

            if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'textarea' ||
                field.type == 'select-one' ||
                field.type == 'radio')  &&
                field.disabled == false) {

                var value = '';
                // get field's value
                if (field.type == "select-one") {
                    var si = field.selectedIndex;
                    if (si >= 0) {
                        value = field.options[si].value;
                    }
                } else {
                    value = field.value;
                }

                if (value.length > 0) {
                    if (!isAllDigits(value)) {
                        bValid = false;
                        if (i == 0) {
                            focusField = field;
                        }
                        fields[i++] = oByte[x][1];

                    } else {

                        var iValue = parseInt(value);
                        if (isNaN(iValue) || !(iValue >= -128 && iValue <= 127)) {
                            if (i == 0) {
                                focusField = field;
                            }
                            fields[i++] = oByte[x][1];
                            bValid = false;
                        }
                    }
                }

            }
        }
        if (fields.length > 0) {
           focusField.focus();
           alert(fields.join('\n'));
        }
        return bValid;
    }


    /*$RCSfile: validateMaxLength.js,v $ $Revision: 1.10 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * A field is considered valid if less than the specified maximum.
    * Fields are not checked if they are disabled.
    * <p>
    * <strong>Caution:</strong> Using <code>validateMaxLength</code> on a password field in a 
    *  login page gives unnecessary information away to hackers. While it only slightly
    *  weakens security, we suggest using it only when modifying a password.</p>
    * @param form The form validation is taking place on.
    */
    function validateMaxLength(form) {
        var isValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name"); 

        oMaxLength = eval('new ' + formName.value + '_maxlength()');        
        for (x in oMaxLength) {
            var field = form[oMaxLength[x][0]];

            if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'password' ||
                field.type == 'textarea') &&
                field.disabled == false) {

                var iMax = parseInt(oMaxLength[x][2]("maxlength"));
                if (field.value.length > iMax) {
                    if (i == 0) {
                        focusField = field;
                    }
                    fields[i++] = oMaxLength[x][1];
                    isValid = false;
                }
            }
        }
        if (fields.length > 0) {
           focusField.focus();
           alert(fields.join('\n'));
        }
        return isValid;
    }


    /*$RCSfile: validateRequired.js,v $ $Revision: 1.13 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    *  Check to see if fields must contain a value.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */

    function validateRequired(form) {
        var isValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name");

        oRequired = eval('new ' + formName.value + '_required()');

        for (x in oRequired) {
            var field = form[oRequired[x][0]];

            if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'textarea' ||
                field.type == 'file' ||
                field.type == 'checkbox' ||
                field.type == 'select-one' ||
                field.type == 'password') &&
                field.disabled == false) {

                var value = '';
                // get field's value
                if (field.type == "select-one") {
                    var si = field.selectedIndex;
                    if (si >= 0) {
                        value = field.options[si].value;
                    }
                } else if (field.type == 'checkbox') {
                    if (field.checked) {
                        value = field.value;
                    }
                } else {
                    value = field.value;
                }

                if (trim(value).length == 0) {

                    if (i == 0) {
                        focusField = field;
                    }
                    fields[i++] = oRequired[x][1];
                    isValid = false;
                }
            } else if (field.type == "select-multiple") { 
                var numOptions = field.options.length;
                lastSelected=-1;
                for(loop=numOptions-1;loop>=0;loop--) {
                    if(field.options[loop].selected) {
                        lastSelected = loop;
                        value = field.options[loop].value;
                        break;
                    }
                }
                if(lastSelected < 0 || trim(value).length == 0) {
                    if(i == 0) {
                        focusField = field;
                    }
                    fields[i++] = oRequired[x][1];
                    isValid=false;
                }
            } else if ((field.length > 0) && (field[0].type == 'radio' || field[0].type == 'checkbox')) {
                isChecked=-1;
                for (loop=0;loop < field.length;loop++) {
                    if (field[loop].checked) {
                        isChecked=loop;
                        break; // only one needs to be checked
                    }
                }
                if (isChecked < 0) {
                    if (i == 0) {
                        focusField = field[0];
                    }
                    fields[i++] = oRequired[x][1];
                    isValid=false;
                }
            }
        }
        if (fields.length > 0) {
           focusField.focus();
           alert(fields.join('\n'));
        }
        return isValid;
    }
    
    // Trim whitespace from left and right sides of s.
    function trim(s) {
        return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
    }


    /*$RCSfile: validateInteger.js,v $ $Revision: 1.9 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * Check to see if fields are a valid integer.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateInteger(form) {
        var bValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name"); 

        oInteger = eval('new ' + formName.value + '_IntegerValidations()');
        for (x in oInteger) {
            var field = form[oInteger[x][0]];

            if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'textarea' ||
                field.type == 'select-one' ||
                field.type == 'radio') &&
                field.disabled == false) {

                var value = '';
                // get field's value
                if (field.type == "select-one") {
                    var si = field.selectedIndex;
                    if (si >= 0) {
                        value = field.options[si].value;
                    }
                } else {
                    value = field.value;
                }

                if (value.length > 0) {

                    if (!isAllDigits(value)) {
                        bValid = false;
                        if (i == 0) {
                            focusField = field;
                        }
                        fields[i++] = oInteger[x][1];

                    } else {
                        var iValue = parseInt(value);
                        if (isNaN(iValue) || !(iValue >= -2147483648 && iValue <= 2147483647)) {
                            if (i == 0) {
                                focusField = field;
                            }
                            fields[i++] = oInteger[x][1];
                            bValid = false;
                       }
                   }
               }
            }
        }
        if (fields.length > 0) {
           focusField.focus();
           alert(fields.join('\n'));
        }
        return bValid;
    }

    function isAllDigits(argvalue) {
        argvalue = argvalue.toString();
        var validChars = "0123456789";
        var startFrom = 0;
        if (argvalue.substring(0, 2) == "0x") {
           validChars = "0123456789abcdefABCDEF";
           startFrom = 2;
        } else if (argvalue.charAt(0) == "0") {
           validChars = "01234567";
           startFrom = 1;
        } else if (argvalue.charAt(0) == "-") {
            startFrom = 1;
        }

        for (var n = startFrom; n < argvalue.length; n++) {
            if (validChars.indexOf(argvalue.substring(n, n+1)) == -1) return false;
        }
        return true;
    }


    /*$RCSfile: validateCreditCard.js,v $ $Revision: 1.8 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * Check to see if fields are a valid creditcard number based on Luhn checksum.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateCreditCard(form) {
        var bValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name");

        oCreditCard = eval('new ' + formName.value + '_creditCard()');

        for (x in oCreditCard) {
            if ((form[oCreditCard[x][0]].type == 'text' ||
                 form[oCreditCard[x][0]].type == 'textarea') &&
                (form[oCreditCard[x][0]].value.length > 0)  &&
                 form[oCreditCard[x][0]].disabled == false) {
                if (!luhnCheck(form[oCreditCard[x][0]].value)) {
                    if (i == 0) {
                        focusField = form[oCreditCard[x][0]];
                    }
                    fields[i++] = oCreditCard[x][1];
                    bValid = false;
                }
            }
        }
        if (fields.length > 0) {
            focusField.focus();
            alert(fields.join('\n'));
        }
        return bValid;
    }

    /**
     * Checks whether a given credit card number has a valid Luhn checksum.
     * This allows you to spot most randomly made-up or garbled credit card numbers immediately.
     * Reference: http://www.speech.cs.cmu.edu/~sburke/pub/luhn_lib.html
     */
    function luhnCheck(cardNumber) {
        if (isLuhnNum(cardNumber)) {
            var no_digit = cardNumber.length;
            var oddoeven = no_digit & 1;
            var sum = 0;
            for (var count = 0; count < no_digit; count++) {
                var digit = parseInt(cardNumber.charAt(count));
                if (!((count & 1) ^ oddoeven)) {
                    digit *= 2;
                    if (digit > 9) digit -= 9;
                };
                sum += digit;
            };
            if (sum == 0) return false;
            if (sum % 10 == 0) return true;
        };
        return false;
    }

    function isLuhnNum(argvalue) {
        argvalue = argvalue.toString();
        if (argvalue.length == 0) {
            return false;
        }
        for (var n = 0; n < argvalue.length; n++) {
            if ((argvalue.substring(n, n+1) < "0") ||
                (argvalue.substring(n,n+1) > "9")) {
                return false;
            }
        }
        return true;
    }


   /*$RCSfile: validateDate.js,v $ $Revision: 1.10 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * Check to see if fields are a valid date.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateDate(form) {
       var bValid = true;
       var focusField = null;
       var i = 0;
       var fields = new Array();
       var formName = form.getAttributeNode("name"); 

       oDate = eval('new ' + formName.value + '_DateValidations()');

       for (x in oDate) {
           var field = form[oDate[x][0]];
           var value = field.value;
           var datePattern = oDate[x][2]("datePatternStrict");
           // try loose pattern
           if (datePattern == null)
               datePattern = oDate[x][2]("datePattern");
           if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'textarea') &&
               (value.length > 0) && (datePattern.length > 0) &&
                field.disabled == false) {
                 var MONTH = "MM";
                 var DAY = "dd";
                 var YEAR = "yyyy";
                 var orderMonth = datePattern.indexOf(MONTH);
                 var orderDay = datePattern.indexOf(DAY);
                 var orderYear = datePattern.indexOf(YEAR);
                 if ((orderDay < orderYear && orderDay > orderMonth)) {
                     var iDelim1 = orderMonth + MONTH.length;
                     var iDelim2 = orderDay + DAY.length;
                     var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
                     var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
                     if (iDelim1 == orderDay && iDelim2 == orderYear) {
                        dateRegexp = new RegExp("^(\\d{2})(\\d{2})(\\d{4})$");
                     } else if (iDelim1 == orderDay) {
                        dateRegexp = new RegExp("^(\\d{2})(\\d{2})[" + delim2 + "](\\d{4})$");
                     } else if (iDelim2 == orderYear) {
                        dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})(\\d{4})$");
                     } else {
                        dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{4})$");
                     }
                     var matched = dateRegexp.exec(value);
                     if(matched != null) {
                        if (!isValidDate(matched[2], matched[1], matched[3])) {
                           if (i == 0) {
                               focusField = field;
                           }
                           fields[i++] = oDate[x][1];
                           bValid =  false;
                        }
                     } else {
                        if (i == 0) {
                            focusField = field;
                        }
                        fields[i++] = oDate[x][1];
                        bValid =  false;
                     }
                 } else if ((orderMonth < orderYear && orderMonth > orderDay)) {
                     var iDelim1 = orderDay + DAY.length;
                     var iDelim2 = orderMonth + MONTH.length;
                     var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
                     var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
                     if (iDelim1 == orderMonth && iDelim2 == orderYear) {
                         dateRegexp = new RegExp("^(\\d{2})(\\d{2})(\\d{4})$");
                     } else if (iDelim1 == orderMonth) {
                         dateRegexp = new RegExp("^(\\d{2})(\\d{2})[" + delim2 + "](\\d{4})$");
                     } else if (iDelim2 == orderYear) {
                         dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})(\\d{4})$");
                     } else {
                         dateRegexp = new RegExp("^(\\d{2})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{4})$");
                     }
                     var matched = dateRegexp.exec(value);
                     if(matched != null) {
                         if (!isValidDate(matched[1], matched[2], matched[3])) {
                             if (i == 0) {
                         focusField = field;
                             }
                             fields[i++] = oDate[x][1];
                             bValid =  false;
                          }
                     } else {
                         if (i == 0) {
                             focusField = field;
                         }
                         fields[i++] = oDate[x][1];
                         bValid =  false;
                     }
                 } else if ((orderMonth > orderYear && orderMonth < orderDay)) {
                     var iDelim1 = orderYear + YEAR.length;
                     var iDelim2 = orderMonth + MONTH.length;
                     var delim1 = datePattern.substring(iDelim1, iDelim1 + 1);
                     var delim2 = datePattern.substring(iDelim2, iDelim2 + 1);
                     if (iDelim1 == orderMonth && iDelim2 == orderDay) {
                         dateRegexp = new RegExp("^(\\d{4})(\\d{2})(\\d{2})$");
                     } else if (iDelim1 == orderMonth) {
                         dateRegexp = new RegExp("^(\\d{4})(\\d{2})[" + delim2 + "](\\d{2})$");
                     } else if (iDelim2 == orderDay) {
                         dateRegexp = new RegExp("^(\\d{4})[" + delim1 + "](\\d{2})(\\d{2})$");
                     } else {
                         dateRegexp = new RegExp("^(\\d{4})[" + delim1 + "](\\d{2})[" + delim2 + "](\\d{2})$");
                     }
                     var matched = dateRegexp.exec(value);
                     if(matched != null) {
                         if (!isValidDate(matched[3], matched[2], matched[1])) {
                             if (i == 0) {
                                 focusField = field;
                             }
                             fields[i++] = oDate[x][1];
                             bValid =  false;
                         }
                     } else {
                          if (i == 0) {
                              focusField = field;
                          }
                          fields[i++] = oDate[x][1];
                          bValid =  false;
                     }
                 } else {
                     if (i == 0) {
                         focusField = field;
                     }
                     fields[i++] = oDate[x][1];
                     bValid =  false;
                 }
          }
       }
       if (fields.length > 0) {
          focusField.focus();
          alert(fields.join('\n'));
       }
       return bValid;
    }
    
    function isValidDate(day, month, year) {
	    if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) &&
            (day == 31)) {
            return false;
        }
        if (month == 2) {
            var leap = (year % 4 == 0 &&
               (year % 100 != 0 || year % 400 == 0));
            if (day>29 || (day == 29 && !leap)) {
                return false;
            }
        }
        return true;
    }


    /*$RCSfile: validateIntRange.js,v $ $Revision: 1.10 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * Check to see if fields is in a valid integer range.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateIntRange(form) {
        var isValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name"); 

        oRange = eval('new ' + formName.value + '_intRange()');        
        for (x in oRange) {
            var field = form[oRange[x][0]];
            if (field.disabled == false)  {
                var value = '';
                if (field.type == 'hidden' ||
                    field.type == 'text' || field.type == 'textarea' ||
                    field.type == 'radio' ) {
                    value = field.value;
                }
                if (field.type == 'select-one') {
                    var si = field.selectedIndex;
                    if (si >= 0) {
                        value = field.options[si].value;
                    }
                }
                if (value.length > 0) {
                    var iMin = parseInt(oRange[x][2]("min"));
                    var iMax = parseInt(oRange[x][2]("max"));
                    var iValue = parseInt(value);
                    if (!(iValue >= iMin && iValue <= iMax)) {
                        if (i == 0) {
                            focusField = field;
                        }
                        fields[i++] = oRange[x][1];
                        isValid = false;
                    }
                }
            }
        }
        if (fields.length > 0) {
            focusField.focus();
            alert(fields.join('\n'));
        }
        return isValid;
    }


    /*$RCSfile: validateShort.js,v $ $Revision: 1.9 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    *  Check to see if fields are a valid short.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateShort(form) {
        var bValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name");

        oShort = eval('new ' + formName.value + '_ShortValidations()');

        for (x in oShort) {
            var field = form[oShort[x][0]];

            if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'textarea' ||
                field.type == 'select-one' ||
                field.type == 'radio')  &&
                field.disabled == false) {

                var value = '';
                // get field's value
                if (field.type == "select-one") {
                    var si = field.selectedIndex;
                    if (si >= 0) {
                        value = field.options[si].value;
                    }
                } else {
                    value = field.value;
                }

                if (value.length > 0) {
                    if (!isAllDigits(value)) {
                        bValid = false;
                        if (i == 0) {
                            focusField = field;
                        }
                        fields[i++] = oShort[x][1];

                    } else {

                        var iValue = parseInt(value);
                        if (isNaN(iValue) || !(iValue >= -32768 && iValue <= 32767)) {
                            if (i == 0) {
                                focusField = field;
                            }
                            fields[i++] = oShort[x][1];
                            bValid = false;
                        }
                   }
               }
            }
        }
        if (fields.length > 0) {
           focusField.focus();
           alert(fields.join('\n'));
        }
        return bValid;
    }


    /*$RCSfile: validateFloat.js,v $ $Revision: 1.11 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * Check to see if fields are a valid float.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateFloat(form) {
        var bValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
         var formName = form.getAttributeNode("name");

        oFloat = eval('new ' + formName.value + '_FloatValidations()');
        for (x in oFloat) {
        	var field = form[oFloat[x][0]];
        	
            if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'textarea' ||
                field.type == 'select-one' ||
                field.type == 'radio') &&
                field.disabled == false) {
        
            	var value = '';
                // get field's value
                if (field.type == "select-one") {
                    var si = field.selectedIndex;
                    if (si >= 0) {
                        value = field.options[si].value;
                    }
                } else {
                    value = field.value;
                }
        
                if (value.length > 0) {
                    // remove '.' before checking digits
                    var tempArray = value.split('.');
                    //Strip off leading '0'
                    var zeroIndex = 0;
                    var joinedString= tempArray.join('');
                    while (joinedString.charAt(zeroIndex) == '0') {
                        zeroIndex++;
                    }
                    var noZeroString = joinedString.substring(zeroIndex,joinedString.length);

                    if (!isAllDigits(noZeroString)) {
                        bValid = false;
                        if (i == 0) {
                            focusField = field;
                        }
                        fields[i++] = oFloat[x][1];

                    } else {
	                var iValue = parseFloat(value);
	                if (isNaN(iValue)) {
	                    if (i == 0) {
	                        focusField = field;
	                    }
	                    fields[i++] = oFloat[x][1];
	                    bValid = false;
	                }
                    }
                }
            }
        }
        if (fields.length > 0) {
           focusField.focus();
           alert(fields.join('\n'));
        }
        return bValid;
    }


   /*$RCSfile: validateEmail.js,v $ $Revision: 1.9 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * Check to see if fields are a valid email address.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateEmail(form) {
        var bValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name");


        oEmail = eval('new ' + formName.value + '_email()');

        for (x in oEmail) {
            var field = form[oEmail[x][0]];
            if ((field.type == 'hidden' || 
                 field.type == 'text' ||
                 field.type == 'textarea') &&
                (field.value.length > 0) &&
                field.disabled == false) {
                if (!checkEmail(field.value)) {
                    if (i == 0) {
                        focusField = field;
                    }
                    fields[i++] = oEmail[x][1];
                    bValid = false;
                }
            }
        }
        if (fields.length > 0) {
            focusField.focus();
            alert(fields.join('\n'));
        }
        return bValid;
    }

    /**
     * Reference: Sandeep V. Tamhankar (stamhankar@hotmail.com),
     * http://javascript.internet.com
     */
    function checkEmail(emailStr) {
       if (emailStr.length == 0) {
           return true;
       }
       var emailPat=/^(.+)@(.+)$/;
       var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]";
       var validChars="\[^\\s" + specialChars + "\]";
       var quotedUser="(\"[^\"]*\")";
       var ipDomainPat=/^(\d{1,3})[.](\d{1,3})[.](\d{1,3})[.](\d{1,3})$/;
       var atom=validChars + '+';
       var word="(" + atom + "|" + quotedUser + ")";
       var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
       var domainPat=new RegExp("^" + atom + "(\\." + atom + ")*$");
       var matchArray=emailStr.match(emailPat);
       if (matchArray == null) {
           return false;
       }
       var user=matchArray[1];
       var domain=matchArray[2];
       if (user.match(userPat) == null) {
           return false;
       }
       var IPArray = domain.match(ipDomainPat);
       if (IPArray != null) {
           for (var i = 1; i <= 4; i++) {
              if (IPArray[i] > 255) {
                 return false;
              }
           }
           return true;
       }
       var domainArray=domain.match(domainPat);
       if (domainArray == null) {
           return false;
       }
       var atomPat=new RegExp(atom,"g");
       var domArr=domain.match(atomPat);
       var len=domArr.length;
       if ((domArr[domArr.length-1].length < 2) ||
           (domArr[domArr.length-1].length > 3)) {
           return false;
       }
       if (len < 2) {
           return false;
       }
       return true;
    }

  


    /*$RCSfile: validateMask.js,v $ $Revision: 1.10 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * Check to see if fields are a valid using a regular expression.
    * Fields are not checked if they are disabled.
    * <p>
    * @param form The form validation is taking place on.
    */
    function validateMask(form) {
        var isValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name"); 

        oMasked = eval('new ' + formName.value + '_mask()');      
        for (x in oMasked) {
            var field = form[oMasked[x][0]];

            if ((field.type == 'hidden' ||
                field.type == 'text' ||
                 field.type == 'textarea' ||
				 field.type == 'file') &&
                 (field.value.length > 0) &&
                 field.disabled == false) {

                if (!matchPattern(field.value, oMasked[x][2]("mask"))) {
                    if (i == 0) {
                        focusField = field;
                    }
                    fields[i++] = oMasked[x][1];
                    isValid = false;
                }
            }
        }

        if (fields.length > 0) {
           focusField.focus();
           alert(fields.join('\n'));
        }
        return isValid;
    }

    function matchPattern(value, mask) {
       return mask.exec(value);
    }


    /*$RCSfile: validateMinLength.js,v $ $Revision: 1.11 $ $Date: 2004/03/28 16:53:21 $ */
    /**
    * A field is considered valid if greater than the specified minimum.
    * Fields are not checked if they are disabled.
    * <p>
    * <strong>Caution:</strong> Using <code>validateMinLength</code> on a password field in a 
    *  login page gives unnecessary information away to hackers. While it only slightly
    *  weakens security, we suggest using it only when modifying a password.</p>
    * @param form The form validation is taking place on.
    */
    function validateMinLength(form) {
        var isValid = true;
        var focusField = null;
        var i = 0;
        var fields = new Array();
        var formName = form.getAttributeNode("name");


        oMinLength = eval('new ' + formName.value + '_minlength()');

        for (x in oMinLength) {
            var field = form[oMinLength[x][0]];

            if ((field.type == 'hidden' ||
                field.type == 'text' ||
                field.type == 'password' ||
                field.type == 'textarea') &&
                field.disabled == false) {

                var iMin = parseInt(oMinLength[x][2]("minlength"));
                if ((trim(field.value).length > 0) && (field.value.length < iMin)) {
                    if (i == 0) {
                        focusField = field;
                    }
                    fields[i++] = oMinLength[x][1];
                    isValid = false;
                }
            }
        }
        if (fields.length > 0) {
           focusField.focus();
           alert(fields.join('\n'));
        }
        return isValid;
    }


//End --> 

   //MyScript
    //jump page
	function nextPage(pageForm)
	{
	/*
		if(pageForm.currentPage.value==parseInt(pageForm.pageCount.value))
		{
			alert("This is the last page!");
			return;
		}
		*/
		pageForm.currentPage.value = parseInt(pageForm.currentPage.value) + 1;
		pageForm.submit();
		
	}
	function prePage(pageForm)
	{
	/* ti shi yu ju
		if(pageForm.currentPage.value==1)
		{
			alert("This is the first page!");
			return;
		}
		*/
		pageForm.currentPage.value = parseInt(pageForm.currentPage.value) - 1;
		pageForm.submit();
	}
	function firstPage(pageForm)
	{
	/*
		if(pageForm.currentPage.value==1)
		{
			alert("This is the first page!");
			return;
		}
		*/
		pageForm.currentPage.value = 1;
		pageForm.submit();
	}
	function lastPage(pageForm)
	{
	/*
		if(pageForm.currentPage.value==parseInt(pageForm.pageCount.value))
		{
			alert("This is the last page!");
			return;
		}
		*/
		pageForm.currentPage.value = parseInt(pageForm.pageCount.value)
		pageForm.submit();
	}
	//重写分页
	function nextPageNew(pageForm, currentPage, pageCount)
	{
		pageForm.currentPage.value = parseInt(pageForm.currentPage.value) + 1;
		pageForm.submit();
		
	}
	function prePageNew(pageForm, currentPage, pageCount)
	{
		pageForm.currentPage.value = parseInt(pageForm.currentPage.value) - 1;
		pageForm.submit();
	}
	function firstPageNew(pageForm, currentPage, pageCount)
	{
		pageForm.currentPage.value = 1;
		pageForm.submit();
	}
	function lastPageNew(pageForm, currentPage, pageCount)
	{
		pageForm.currentPage.value = pageForm.pageCount.value;
		pageForm.submit();
	}
	//后台登录
    var bCancel = false; 
	
    function validateAdminLoginForm(form) { 
        if (bCancel) { 
            return true; 
        } else { 
            var formValidationResult; 
            formValidationResult = validateRequired(form); 
            return (formValidationResult == 1); 
        } 
    } 

    function adminLoginForm_required () { 
     this.a0 = new Array("userName", "请输入用户名", new Function ("varName", " return this[varName];"));
     this.a1 = new Array("pass", "请输入密码", new Function ("varName", " return this[varName];"));
     this.a2 = new Array("code", "请输入验证码", new Function ("varName", " return this[varName];"));
    } 
	//客户登录
    function validateClientLoginForm(form) { 
        if (bCancel) { 
            return true; 
        } else { 
            var formValidationResult; 
            formValidationResult = validateRequired(form); 
            return (formValidationResult == 1); 
        } 
    } 

    function clientLoginForm_required () { 
     this.a0 = new Array("name", "请输入用户名", new Function ("varName", " return this[varName];"));
     this.a1 = new Array("pass", "请输入密码", new Function ("varName", " return this[varName];"));
     this.a2 = new Array("code", "请输入验证码", new Function ("varName", " return this[varName];"));
    } 
	//检查用户名

	function checkNameFormSubmit()
	{
		var tmp = clientRegForm.name.value;
		
		if (tmp.length == 0 || tmp == null)
		{
			alert("请输入用户名");
		}
		else if (tmp.length > 24)
		{
			alert("用户名长请不能大于24个字符");
		}
		else
		{
			checkNameForm.userName.value=clientRegForm.name.value;
			checkNameForm.submit();
		}

	}
	//客户注册
    function validateClientRegForm(form) { 
        if (bCancel) { 
            return true; 
        } else { 
            var formValidationResult; 
            formValidationResult = validateRequired(form) && validateMaxLength(form) && validateMinLength(form) && validateEmail(form); 
            return (formValidationResult); 
        } 
    } 
	

    function clientRegForm_required () { 
     this.a0 = new Array("sex", "请选择性别", new Function ("varName", " return this[varName];"));
     this.a1 = new Array("name", "请输入用户名", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a2 = new Array("pass", "请输入密码", new Function ("varName", "this.maxlength='24'; this.minlength='6';  return this[varName];"));
     this.a3 = new Array("repass", "请输入确认密码", new Function ("varName", "this.test='(*this* == pass)';  return this[varName];"));
     this.a4 = new Array("mail", "请输入电子邮箱", new Function ("varName", " return this[varName];"));
     this.a5 = new Array("code", "请输入验证码", new Function ("varName", "this.maxlength='4'; this.minlength='4';  return this[varName];"));
    } 

    function clientRegForm_maxlength () { 
     this.a0 = new Array("name", "用户名长度必须小于 24 个字符.", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a1 = new Array("pass", "密码长度必须小于 24 个字符.", new Function ("varName", "this.maxlength='24'; this.minlength='6';  return this[varName];"));
     this.a2 = new Array("code", "验证码长度必须小于 4 个字符.", new Function ("varName", "this.maxlength='4'; this.minlength='4';  return this[varName];"));
    } 

    function clientRegForm_minlength () { 
     this.a0 = new Array("pass", "密码长度必须大于 6 位.", new Function ("varName", "this.maxlength='24'; this.minlength='6';  return this[varName];"));
     this.a1 = new Array("code", "验证码长度必须大于 4 位.", new Function ("varName", "this.maxlength='4'; this.minlength='4';  return this[varName];"));
    } 

    function clientRegForm_email () { 
     this.a0 = new Array("mail", "电子邮箱必须是个有效的E-Mail地址.", new Function ("varName", " return this[varName];"));
    } 
	//添加相册
    function validateAddAlbumForm(form) { 
        if (bCancel) { 
            return true; 
        } else { 
            var formValidationResult; 
            formValidationResult = validateRequired(form) && validateMaxLength(form) && validateMinLength(form); 
            return (formValidationResult); 
        } 
    } 

    function addAlbumForm_required () { 
     this.a0 = new Array("name", "请输入相册名", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a1 = new Array("kind", "请输入相册种类", new Function ("varName", " return this[varName];"));
     this.a2 = new Array("desc", "请输入相册描述", new Function ("varName", "this.maxlength='200';  return this[varName];"));
     this.a3 = new Array("code", "请输入验证码", new Function ("varName", "this.maxlength='4'; this.minlength='4';  return this[varName];"));
    } 

    function addAlbumForm_maxlength () { 
     this.a0 = new Array("name", "相册名长度必须小于 24 个字符.", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a1 = new Array("desc", "相册描述长度必须小于 200 个字符.", new Function ("varName", "this.maxlength='200';  return this[varName];"));
     this.a2 = new Array("code", "验证码长度必须小于 4 个字符.", new Function ("varName", "this.maxlength='4'; this.minlength='4';  return this[varName];"));
    } 

    function addAlbumForm_minlength () { 
     this.a0 = new Array("code", "验证码长度必须大于 4 位.", new Function ("varName", "this.maxlength='4'; this.minlength='4';  return this[varName];"));
    } 
	//修改用户资料
    function validateUpdateInfoForm(form) { 
        if (bCancel) { 
            return true; 
        } else { 
            var formValidationResult; 
            formValidationResult = validateMaxLength(form) && validateRequired(form) && validateEmail(form) && validateMinLength(form); 
            return (formValidationResult); 
        } 
    } 

    function updateInfoForm_maxlength () { 
     this.a0 = new Array("qq", "QQ号长度必须小于 24 个字符.", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a1 = new Array("code", "验证码长度必须小于 4 个字符.", new Function ("varName", "this.maxlength='4'; this.minlength='4';  return this[varName];"));
    } 

    function updateInfoForm_required () { 
     this.a0 = new Array("mail", "请输入电子邮箱", new Function ("varName", " return this[varName];"));
     this.a1 = new Array("code", "请输入验证码", new Function ("varName", "this.maxlength='4'; this.minlength='4';  return this[varName];"));
    } 

    function updateInfoForm_email () { 
     this.a0 = new Array("mail", "电子邮箱必须是个有效的E-Mail地址.", new Function ("varName", " return this[varName];"));
    } 

    function updateInfoForm_minlength () { 
     this.a0 = new Array("code", "验证码长度必须大于 4 位.", new Function ("varName", "this.maxlength='4'; this.minlength='4';  return this[varName];"));
    } 
	//修改密码
    function validateUpdatePassForm(form) { 
        if (bCancel) { 
            return true; 
        } else { 
            var formValidationResult; 
            formValidationResult = validateRequired(form) && validateMinLength(form) && validateMaxLength(form); 
            return (formValidationResult); 
        } 
    } 

    function updatePassForm_required () { 
     this.a0 = new Array("old", "请输入旧密码", new Function ("varName", "this.maxlength='24'; this.minlength='6';  return this[varName];"));
     this.a1 = new Array("newPass", "请输入新密码", new Function ("varName", "this.maxlength='24'; this.minlength='6';  return this[varName];"));
     this.a2 = new Array("rePass", "请输入确认密码", new Function ("varName", "this.test='(*this* == newPass)';  return this[varName];"));
    } 

    function updatePassForm_minlength () { 
     this.a0 = new Array("old", "旧密码长度必须大于 6 位.", new Function ("varName", "this.maxlength='24'; this.minlength='6';  return this[varName];"));
     this.a1 = new Array("newPass", "新密码长度必须大于 6 位.", new Function ("varName", "this.maxlength='24'; this.minlength='6';  return this[varName];"));
    } 

    function updatePassForm_maxlength () { 
     this.a0 = new Array("old", "旧密码长度必须小于 24 个字符.", new Function ("varName", "this.maxlength='24'; this.minlength='6';  return this[varName];"));
     this.a1 = new Array("newPass", "新密码长度必须小于 24 个字符.", new Function ("varName", "this.maxlength='24'; this.minlength='6';  return this[varName];"));
    } 
	//修改相册信息
    function validateUpdateAlbumForm(form) { 
        if (bCancel) { 
            return true; 
        } else { 
            var formValidationResult; 
            formValidationResult = validateRequired(form) && validateMaxLength(form); 
            return (formValidationResult); 
        } 
    } 

    function updateAlbumForm_required () { 
     this.a0 = new Array("name", "请输入相册名", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a1 = new Array("kind", "请输入相册种类", new Function ("varName", " return this[varName];"));
     this.a2 = new Array("desc", "请输入相册描述", new Function ("varName", "this.maxlength='200';  return this[varName];"));
    } 

    function updateAlbumForm_maxlength () { 
     this.a0 = new Array("name", "相册名长度必须小于 24 个字符.", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a1 = new Array("desc", "相册描述长度必须小于 200 个字符.", new Function ("varName", "this.maxlength='200';  return this[varName];"));
    } 
	//添加相片
    function validateAddPhotoForm(form) { 
        if (bCancel) { 
            return true; 
        } else { 
            var formValidationResult; 
            formValidationResult = validateRequired(form) && validateMaxLength(form); 
            return (formValidationResult); 
        } 
    } 

    function addPhotoForm_required () { 
     this.a0 = new Array("name", "请输入相册名", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a1 = new Array("image", "请输入照片", new Function ("varName", " return this[varName];"));
     this.a2 = new Array("desc", "请输入相册描述", new Function ("varName", "this.maxlength='200';  return this[varName];"));
    } 

    function addPhotoForm_maxlength () { 
     this.a0 = new Array("name", "相册名长度必须小于 24 个字符.", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a1 = new Array("desc", "相册描述长度必须小于 200 个字符.", new Function ("varName", "this.maxlength='200';  return this[varName];"));
    } 

	//发表评论
	function showCommentForm()
	{
		if (document.getElementById("commentForm").style.display == "block")
		{
			document.getElementById("commentForm").style.display = "none";
		}
		else
		{
			document.getElementById("commentForm").style.display = "block";
		}
	}
	//验证发评论
    function validateCommentForm(form) { 
        if (bCancel) { 
            return true; 
        } else { 
            var formValidationResult; 
            formValidationResult = validateRequired(form) && validateMaxLength(form); 
            return (formValidationResult); 
        } 
    } 
	//添加种类
    function validateAddKindForm(form) { 
        if (bCancel) { 
            return true; 
        } else { 
            var formValidationResult; 
            formValidationResult = validateRequired(form) && validateMaxLength(form); 
            return (formValidationResult); 
        } 
    } 

    function addKindForm_required () { 
     this.a0 = new Array("name", "请输入种类名", new Function ("varName", "this.maxlength='8';  return this[varName];"));
    } 

    function addKindForm_maxlength () { 
     this.a0 = new Array("name", "种类名长度必须小于 8 个字符.", new Function ("varName", "this.maxlength='8';  return this[varName];"));
    } 

    function commentForm_required () { 
     this.a0 = new Array("title", "请输入标题", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a1 = new Array("content", "请输入内容", new Function ("varName", "this.maxlength='200';  return this[varName];"));
    } 

    function commentForm_maxlength () { 
     this.a0 = new Array("title", "标题长度必须小于 24 个字符.", new Function ("varName", "this.maxlength='24';  return this[varName];"));
     this.a1 = new Array("content", "内容长度必须小于 200 个字符.", new Function ("varName", "this.maxlength='200';  return this[varName];"));
    } 
	//神哥的JAVASCRIPT
	//memberLongin.jsp页面
	today=new Date();
	jran=today.getTime();

	function rnd() {

		ia=9301;
		ic=49297;
		im=233280;

		jran = (jran*ia+ic) % im;
		return jran/(im*1.0);
	};

//register.jsp

