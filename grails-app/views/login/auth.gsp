<html>
<head>
	<meta name='layout' content='bootstrap'/>

	<style type="text/css">
	      .form-signin {
	        max-width: 300px;
	        padding: 19px 29px 29px;
	        margin: 0 auto 20px;
	        background-color: #fff;
	        border: 1px solid #e5e5e5;
	        -webkit-border-radius: 5px;
	           -moz-border-radius: 5px;
	                border-radius: 5px;
	        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
	           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
	                box-shadow: 0 1px 2px rgba(0,0,0,.05);
	      }
	      .form-signin .form-signin-heading,
	      .form-signin .checkbox {
	        margin-bottom: 10px;
	      }
	      .form-signin input[type="text"],
	      .form-signin input[type="password"] {
	        font-size: 16px;
	        height: auto;
	        margin-bottom: 15px;
	        padding: 7px 9px;
	      }      
	    </style>
</head>

<body>

    <div class="container">

		<form action='${postUrl}' method='POST' id='loginForm' class='form-signin' autocomplete='off'>
		
			<h2 class="form-signin-heading"><g:message code="springSecurity.login.header"/></h2>

			<g:if test='${flash.message}'>
				<div class='alert alert-error'>${flash.message}</div>
			</g:if>

			<p>
				<input type='text' placeholder="<g:message code='springSecurity.login.username.label'/>" name='j_username' id='username'/>
			</p>

			<p>
				<input type='password' placeholder="<g:message code='springSecurity.login.password.label'/>" name='j_password' id='password'/>
			</p>

			<label class="checkbox">
          		<input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>
				<label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>
        	</label>

			<p>
				<input class="btn btn-large btn-primary" type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>
			</p>
		</form>

    </div> <!-- /container -->

<script type='text/javascript'>
	<!--
	(function() {
		document.forms['loginForm'].elements['j_username'].focus();
	})();
	// -->
</script>
</body>
</html>
