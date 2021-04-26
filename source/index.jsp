<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

        
    <form method = 'get'
    action = '/movied' 
    accept-charset="utf-8" name = "person_info">
    <fieldset Style = "width:150">
        <legend> MOVIE </legend>
        
        MNAME : <input type = "text" name = "mymname" required/><br><br>
        MNUM : <input type = "text" name = "mymnum" required/><br><br>
        FILM_DISTRIBUTOR : <input type = "text" name = "myfilm" required/><br><br>
        DIRECTOR_DNUM : <input type = "text" name = "mymdnum" required/><br><br>
        PRODCUER_PNUM : <input type = "text" name = "mympnum" required/><br><br>
        
        
        <input name="submit" type = "submit" value = "SELECT_MOVIE">
        <input name="submit" type = "submit" value = "INSERT_MOVIE">
        <input name="submit" type = "submit" value = "DELETE_MOVIE">
        <input name="submit" type = "submit" value = "UPDATE_MOVIE">
    </fieldset>
    </form>	
    
        <form method = 'get'
        action = '/movied' 
    accept-charset="utf-8" name = "person_info">
    <fieldset Style = "width:150">
        <legend> ACTOR </legend>
        
        NAME : <input type = "text" name = "myaname" required/><br><br>
        ANUM : <input type = "text" name = "myanum" required/><br><br>
        ALSO DIRECTOR : <input type = "text" name = "myadnum" /><br><br>
        ALSO PRODUCER : <input type = "text" name = "myapnum" /><br><br>
        MOVIE : <input type = "text" name = "mydnn" /><br><br>
        (ONLY FOR UPDATE) BEFORE MOVIE : <input type = "text" name = "myunn" /><br><br>
        
        PERFORM : <input type = "checkbox" name = "performs"/>
        LEAD ROLE : <input type = "checkbox" name = "lead_role"/><br><br>
        
        <input name="submit" type = "submit" value = "SELECT_ACTOR">
        <input name="submit" type = "submit" value = "INSERT_ACTOR">
        <input name="submit" type = "submit" value = "DELETE_ACTOR">
        <input name="submit" type = "submit" value = "UPDATE_ACTOR">
    </fieldset>
    </form>	
    
            <form method = 'get'
            action = '/movied' 
    accept-charset="utf-8" name = "person_info">
    <fieldset Style = "width:150">
        <legend> DIRECTOR </legend>
        
        DNAME : <input type = "text" name = "mydname" required/><br><br>
        DNUM : <input type = "text" name = "mydnum" required/><br><br>
        
        
        <input name="submit" type = "submit" value = "SELECT_DIRECTOR">
        <input name="submit" type = "submit" value = "INSERT_DIRECTOR">
        <input name="submit" type = "submit" value = "DELETE_DIRECTOR">
        <input name="submit" type = "submit" value = "UPDATE_DIRECTOR">
    </fieldset>
    </form>	
    
            <form method = 'get'
            action = '/movied' 
    accept-charset="utf-8" name = "person_info">
    <fieldset Style = "width:150">
        <legend> PRODUCER </legend>
        
        PNAME : <input type = "text" name = "mypname" required/><br><br>
        PNUM : <input type = "text" name = "mypnum" required/><br><br>
        
        
        <input name="submit" type = "submit" value = "SELECT_PRODUCER">
        <input name="submit" type = "submit" value = "INSERT_PRODUCER">
        <input name="submit" type = "submit" value = "DELETE_PRODUCER">
        <input name="submit" type = "submit" value = "UPDATE_PRODUCER">
    </fieldset>
    </form>	

        <form method = 'get'
        action = '/movied' 
    accept-charset="utf-8" name = "person_info">
    <fieldset Style = "width:150">
    <legend> ACTOR_LEAD </legend>
    
    <input name="submit" type = "submit" value = "_VIEW">
    </fieldset>
    </form>	
</body>
</html>

