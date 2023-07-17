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



		let newGenere = { "nome": nome.value };
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
	})
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



		let newAttore = { "nome": nome.value };
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
	})
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
		<input type="number" class="form-control" id="durata">
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
	})
}

function utenteForm() {
	s = "";

	s = `
    <h3>Registrazione Utente</h3>
	<form id="forma">
	<div class="mb-3">
		<label for="nickname" class="form-label">Nickname</label>
		<input type="text" class="form-control" id="nickname">
	</div>
    <div class="mb-3">
		<label for="nome" class="form-label">Nome</label>
		<input type="text" class="form-control" id="nome">
	</div>
    <div class="mb-3">
		<label for="cognome" class="form-label">Cognome</label>
		<input type="text" class="form-control" id="cognome">
	</div>
    <div class="mb-3">
		<label for="dataNascita" class="form-label">Data Di Nascita</label>
		<input type="date" class="form-control" id="dataNascita">
	</div>
    <div class="mb-3">
		<label for="email" class="form-label">Email</label>
		<input type="email" class="form-control" id="email">
	</div>
    <div class="mb-3">
		<label for="password" class="form-label">Password</label>
		<input type="password" class="form-control" id="password">
	</div>
	<div class="mb-3">
		<label for="telefono" class="form-label">Telefono</label>
		<input type="text" class="form-control" id="telefono">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
	</form>
		`;

	formTarget.innerHTML = s;

	let formina = document.getElementById("forma");
	formina.addEventListener("submit", (e) => {
		e.preventDefault();

		let nickname = document.getElementById('nickname');
		let nome = document.getElementById('nome');
		let cognome = document.getElementById('cognome');
		let dataNascita = document.getElementById('dataNascita');
		let email = document.getElementById('email');
		let password = document.getElementById('password');
		let telefono = document.getElementById('telefono');

		console.log(typeof nickname.value)
		console.log(typeof nome.value)
		console.log(typeof cognome.value)
		console.log(typeof dataNascita.value)
		console.log(typeof email.value)
		str = JSON.stringify(email.value); // (Optional) beautiful indented output.
		console.log(str); // Logs output to dev tools console.
		console.log(typeof password.value)
		console.log(typeof telefono.value)



		let newUtente = {
			"nickname": nickname.value,
			"nome": nome.value,
			"cognome": cognome.value,
			"dataDiNascita": dataNascita.value,
			"email": email.value,
			"password": password.value,
			"telefono": telefono.value
		};
		console.log(newUtente.value)


		fetch("http://localhost:8080/api/v1/admin/utente/addUtente",
			{
				method: 'POST',
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(newUtente)
			}
		)
			.then(console.log("success"));
	})
}

function ruoloForm() {
	s = "";

	s = `
    <h3>Form Ruolo</h3>
	<form id="forma">
	<div class="mb-3">
		<label for="ruolo" class="form-label">Nome</label>
		<input type="text" class="form-control" id="ruolo">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
	</form>
		`;

	formTarget.innerHTML = s;

	let formina = document.getElementById("forma");
	formina.addEventListener("submit", (e) => {
		e.preventDefault();

		let nome = document.getElementById('ruolo');

		console.log(typeof nome.value)



		let newRuolo = { "nome": nome.value };
		console.log(newRuolo.value)


		fetch("http://localhost:8080/api/v1/admin/ruolo/addRuolo",
			{
				method: 'POST',
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(newRuolo)
			}
		)
			.then(console.log("success"));
	})
}

function attoriList() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/lumiere/attori/all")
		.then(res => res.json())
		.then(listaAttori => {
			console.log(listaAttori);
			s = `
				<div class="row">
   					<div class="col">
						<h5>Nomi Attori</h5>
    				</div>
  				</div>
			`;
			for (attore of listaAttori) {
				s += `
  				<div class="row">
   					<div class="col">
						<p>${attore.nome}</p>
    				</div>
					<!-- <div class="d-flex justify-content-end">
						<button id="attoreDelete" class="btn btn-sm position-absolute pt-0" onclick="elimina(${attore.id})">x</button>
					</div> -->
  				</div>
			 	`;
			}
			listTarget.innerHTML = s;
		});
}

function generiList() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/lumiere/generi/all")
		.then(res => res.json())
		.then(listaGeneri => {
			console.log(listaGeneri);
			s = `
				<div class="row">
   					<div class="col">
						<h5>Nomi Generi</h5>
    				</div>
  				</div>
			 	`;
			for (genere of listaGeneri) {
				s += `
  				<div class="row">
   					<div class="col">
						<p>${genere.nome}</p>
    				</div>
					<!-- <div class="d-flex justify-content-end">
						<button id="genereDelete" class="btn btn-sm position-absolute pt-0" onclick="elimina(${genere.id})">x</button>
					</div> -->
  				</div>
			 	`;
			}
			listTarget.innerHTML = s;
		});
}

function filmList() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/lumiere/films/all")
		.then(res => res.json())
		.then(listaFilms => {
			console.log(listaFilms);
			g = "";
			a = "";
			s =  `
			<div class="row">
				<div class="col">
					 <h5>Titolo Film</h5>
				 </div>
				<div class="col">
					 <h5>Data Di Uscita</h5>
				 </div>
				 <div class="col">
					 <h5>Durata Del Film</h5>
				 </div>
				<div class="col">
					 <h5>Regista</h5>
				 </div>
				 <div class="col">
					 <h5>Paese Di Produzione</h5>
				 </div>
				<div class="col">
					 <h5>Lingua Originale</h5>
				 </div>
				 <div class="col">
					 <h5>Attori</h5>
				 </div>
				<div class="col">
					 <h5>Generi</h5>
				 </div>
				<div class="col">
				 <h5>Locandina</h5>
				 </div>
				 <div class="col">
					 <h5>Trama</h5>
				 </div>
			   </div>
			 `;
			for (film of listaFilms) {
				let attoriJSON = JSON.stringify(film.attori)
				let attori = JSON.parse(attoriJSON);
				let generiJSON = JSON.stringify(film.generi)
				let generi = JSON.parse(generiJSON);
				
				s += `
				<div class="row">
					<div class="col">
				 		<p>${film.titolo}</p>
			 		</div>
					<div class="col">
					 	<p>${film.anno}</p>
				 	</div>
				 	<div class="col">
				 		<p>${film.durata}</p>
			 		</div>
					<div class="col">
					 	<p>${film.regista}</p>
				 	</div>
				 	<div class="col">
				 		<p>${film.paese}</p>
			 		</div>
					<div class="col">
					 	<p>${film.lingua}</p>
				 	</div>
				 	<div class="col">
				 		 ${a}
			 		</div>
					<div class="col">
					 	${g}
				 	</div>
					<div class="col">
					 <p>${film.locandina}</p>
				 	</div>
				 	<div class="col">
					 	<p>${film.trama}</p>
				 	</div>
			 		<!-- <div class="d-flex justify-content-end">
				 		<button id="attoreDelete" class="btn btn-sm position-absolute pt-0" onclick="elimina(${film.id})">x</button>
			 		</div> -->
		   		</div>
			 	`;
				
				for (gen of generi) {
					console.log(g);
					g += `<p>${gen.nome}</p>`;
					}
				
				
				for (att of attori) {
					console.log(a);
					a += `<p>${att.nome}</p>`;
					}
			
			}
			listTarget.innerHTML = s;
		});
}

function utentiList() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/admin/utenti/all")
		.then(res => res.json())
		.then(listaUtenti => {
			console.log(listaUtenti);
			s = `
			<div class="row">
				<div class="col">
					<h5>Nickname</h5>
				</div>
				<div class="col">
					<h5>Nome</h5>
				</div>
				<div class="col">
					<h5>Cognome</h5>
				</div>
				<div class="col">
					<h5>Data Di Nascita</h5>
				</div>
				<div class="col">
					<h5>Email</h5>
				</div>
				<div class="col">
					<h5>Password</h5>
				</div>
				<div class="col">
					<h5>Telefono</h5>
				</div>
				<div class="col">
					<h5>Attivo</h5>
				</div>
				<div class="col">
				 	<h5>Ruoli</h5>
				</div>
			</div>
			 `;
			for (utente of listaUtenti) {
				let ruoli = JSON.stringify(utente.ruoli)
				s += `
				<div class="row">
					<div class="col">
				 		<p>${utente.nickname}</p>
			 		</div>
					<div class="col">
					 	<p>${utente.nome}</p>
				 	</div>
				 	<div class="col">
				 		<p>${utente.cognome}</p>
			 		</div>
					<div class="col">
					 	<p>${utente.dataDiNascita}</p>
				 	</div>
				 	<div class="col">
				 		<p>${utente.email}</p>
			 		</div>
					<div class="col">
					 	<p>${utente.password}</p>
				 	</div>
				 	<div class="col">
				 		<p>${utente.telefono}</p>
			 		</div>
					<div class="col">
					 	<p>${utente.attivo}</p>
				 	</div>
					<div class="col">
					 	<p>${ruoli.nome}</p>
				 	</div>
			 		<!-- <div class="d-flex justify-content-end">
				 		<button id="attoreDelete" class="btn btn-sm position-absolute pt-0" onclick="elimina(${film.id})">x</button>
			 		</div> -->
		   		</div>
			 	`;
			}
			listTarget.innerHTML = s;
		});
}