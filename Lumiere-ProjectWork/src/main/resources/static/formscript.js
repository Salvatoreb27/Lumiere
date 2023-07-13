function genereForm() {
	s = "";

	s = `
    <h3>Form Genere</h3>
	<form id="forma">
	<div class="mb-3">
		<label for="genere" class="form-label">Nome</label>
		<input type="text" class="form-control" id="genere">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
	</form>
		`;

	formTarget.innerHTML = s;
	
	  let formina = document.getElementById("forma");
        formina.addEventListener("submit", (e) => {
				e.preventDefault();
				
				let nome = document.getElementById('genere');
			
				console.log(typeof nome.value)
				
				
				
	            let newGenere = {"nome": nome.value};
				console.log(newGenere.value)


	            fetch("http://localhost:8080/api/v1/admin/genere/addGenere", 
	            {
	                method: 'POST',
	                headers: {
	                    "Content-Type": "application/json"
	                },
	                body: JSON.stringify(newGenere)
	            }
	            )
                .then(console.log("success"));
			} )
}

function attoreForm() {
	s = "";

	s = `
    <h3>Form Attore</h3>
	<form id="forma">
	<div class="mb-3">
		<label for="attore" class="form-label">Nome</label>
		<input type="text" class="form-control" id="attore">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
	</form>
		`;

	formTarget.innerHTML = s;
	
	  let formina = document.getElementById("forma");
        formina.addEventListener("submit", (e) => {
				e.preventDefault();
				
				let nome = document.getElementById('attore');
			
				console.log(typeof nome.value)
				
				
				
	            let newAttore = {"nome": nome.value};
				console.log(newAttore.value)


	            fetch("http://localhost:8080/api/v1/admin/attore/addAttore", 
	            {
	                method: 'POST',
	                headers: {
	                    "Content-Type": "application/json"
	                },
	                body: JSON.stringify(newAttore)
	            }
	            )
                .then(console.log("success"));
			} )
}

function filmForm() {
	s = "";

	s = `
    <h3>Form Film</h3>
	<form id="forma">
	<div class="mb-3">
		<label for="titolo" class="form-label">Titolo</label>
		<input type="text" class="form-control" id="titolo">
	</div>
    <div class="mb-3">
		<label for="anno" class="form-label">Anno Di Produzione</label>
		<input type="date" class="form-control" id="anno">
	</div>
    <div class="mb-3">
		<label for="durata" class="form-label">Durata</label>
		<input type="time" class="form-control" id="durata">
	</div>
    <div class="mb-3">
		<label for="regista" class="form-label">Regista</label>
		<input type="text" class="form-control" id="regista">
	</div>
    <div class="mb-3">
		<label for="paese" class="form-label">Paese Di Produzione</label>
		<input type="text" class="form-control" id="paese">
	</div>
    <div class="mb-3">
		<label for="lingua" class="form-label">Lingua Del Film</label>
		<input type="text" class="form-control" id="lingua">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
	</form>
		`;

	formTarget.innerHTML = s;
	
	  let formina = document.getElementById("forma");
        formina.addEventListener("submit", (e) => {
				e.preventDefault();
				
				let titolo = document.getElementById('titolo');
                let anno = document.getElementById('anno');
                let durata = document.getElementById('durata');
                let regista = document.getElementById('regista');
                let paese = document.getElementById('paese');
                let lingua = document.getElementById('lingua');
			
				console.log(typeof titolo.value)
                console.log(typeof anno.value)
                console.log(anno.value)
                console.log(typeof durata.value)
                console.log(durata.value)
                console.log(typeof regista.value)
                console.log(typeof paese.value)
                console.log(typeof lingua.value)
				
				
				
	            let newFilm = {
                    "titolo": titolo.value, 
                    "anno": anno.value, 
                    "durata": durata.value,
                    "regista": regista.value,
                    "paese": paese.value,
                    "lingua": lingua.value,
                    "generi": [{
        			"id": 1,
        			"nome": "horror"
   					 }]
                };
				console.log(newFilm.value)


	            fetch("http://localhost:8080/api/v1/admin/film/addFilm", 
	            {
	                method: 'POST',
	                headers: {
	                    "Content-Type": "application/json"
	                },
	                body: JSON.stringify(newFilm)
	            }
	            )
                .then(console.log("success"));
			} )
}


  
