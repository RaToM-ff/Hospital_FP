window.onload = function() {
        	let filter = document.getElementById("filter").getAttribute("filterValue");
            if(filter != "") {
            	document.getElementById("filter_"+filter).selected = "selected";
        	}
        	//document.getElementById("load_body").setAttribute("hidden","");
			document.getElementById("main_body").removeAttribute("hidden");
        };