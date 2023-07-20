function genereForm() {
	s = "";

	s = `
    <h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Form Genere</h2>
	<form id="forma">
	<div class="mb-3">
		<label for="genere" class="form-label">Nome</label>
		<input type="text" class="form-control" id="genere">
	</div>
	<button type="submit" class="btn btn-primary"  style="background-color: #FFD369; color: #222831; border-color: #393E46;">Submit</button>
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
	<h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Form Attore</h2>	
	<form id="forma">
	<div class="mb-3">
		<label for="attore" class="form-label">Nome</label>
		<input type="text" class="form-control" id="attore">
	</div>
	<button type="submit" class="btn btn-primary" style="background-color: #FFD369; color: #222831; border-color: #393E46;">Submit</button>
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
    <h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Form Film</h2>
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
	<button type="submit" class="btn btn-primary" style="background-color: #FFD369; color: #222831; border-color: #393E46;" >Submit</button>
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
	<h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Registrazione Utente</h2>	<form id="forma">
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
	<button type="submit" class="btn btn-primary"  style="background-color: #FFD369; color: #222831; border-color: #393E46;" ">Submit</button>
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
			"telefono": telefono.value,
			"attivo": 1
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
	<h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Form Ruolo</h2>	<form id="forma">
	<div class="mb-3">
		<label for="ruolo" class="form-label">Nome</label>
		<input type="text" class="form-control" id="ruolo">
	</div>
	<button type="submit" class="btn btn-primary" style="background-color: #FFD369; color: #222831; border-color: #393E46;" ">Submit</button>
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

//inizio liste

function attoriList() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/lumiere/attori/all")
		.then(res => res.json())
		.then(listaAttori => {
			console.log(listaAttori);
			i = 0;
			s = `
			<h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Lista Attori</h3>

				<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nomi Attori</th>
						<th scope="col">Modifica</th>
						<th scope="col">Cancella</th>
					</tr>
				</thead>
				<tbody>
			`;
			for (attore of listaAttori) {
				i++;
				s += `
  				<tr>
      				<th scope="row">${i}</th>
      				<td>${attore.nome}</td>
      				<td><button class="btn btn-sm ms-1 pt-0" style="background-color: #FFD369!important; color: #222831; border-color: #393E46; onclick="attoreUpdate(${attore.id})"><i class="bi bi-pencil-square"></i></button></td>
      				<td><button class="btn btn-sm ms-1 pt-0" style="background-color: #FFD369!important; color: #222831; border-color: #393E46; onclick="attoreDelete(${attore.id})"><i class="bi bi-x"></i></button></td>
    			</tr>
			 	`;
			}
			s += `
			 		</tbody>
			 	</table>
			 	`
			listTarget.innerHTML = s;
		});
}

function generiList() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/lumiere/generi/all")
		.then(res => res.json())
		.then(listaGeneri => {
			console.log(listaGeneri);
			i = 0;
			s = `
			<h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Lista Generi</h3>

				<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nome Genere</th>
						<th scope="col">Modifica</th>
						<th scope="col">Cancella</th>
					</tr>
				</thead>
				<tbody>
			 	`;
			for (genere of listaGeneri) {
				i++;
				s += `
				<tr>
      				<th scope="row">${i}</th>
      				<td>${genere.nome}</td>
      				<td><button class="btn btn-sm ms-1 pt-0 bg-light" onclick="genereUpdate(${genere.id})"><i class="bi bi-pencil-square"></button></td>
      				<td><button class="btn btn-sm ms-1 pt-0 bg-light" onclick="genereDelete(${genere.id})"><i class="bi bi-x"></i></button></td>
    			</tr>
			 	`;
			}
			s += `
			 		</tbody>
			 	</table>
			 	`
			listTarget.innerHTML = s;
		});
}

function filmList() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/lumiere/films/all")
		.then(res => res.json())
		.then(listaFilms => {
			console.log(listaFilms);
			i = 0;
			g = "";
			a = "";
			s =  `
			<h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Lista Film</h3>
			<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Titolo Film</th>
						<th scope="col">Data Di Uscita</th>
						<th scope="col">Durata Del Film</th>
						<th scope="col">Regista</th>
						<th scope="col">Paese Di Produzione</th>
						<th scope="col">Lingua Originale</th>
						<th scope="col">Attori</th>
						<th scope="col">Generi</th>
						<th scope="col">Locandina</th>
						<th scope="col">Trailer</th>
						<th scope="col">Trama</th>
						<th scope="col">Modifica</th>
						<th scope="col">Cancella</th>
					</tr>
				</thead>
				<hr>
				<tbody>
			 `;
			for (film of listaFilms) {
				i++;
				console.log(film.id)
				console.log(typeof(film.id))
				let attoriJSON = JSON.stringify(film.attori);
				console.log(attoriJSON);
				let attori = JSON.parse(attoriJSON);
				console.log(attori);
				let generiJSON = JSON.stringify(film.generi);
				console.log(generiJSON);
				let generi = JSON.parse(generiJSON);
				console.log(generi);
				
				for (gen of generi) {
					console.log(gen);
					g += `<p>${gen.nome}</p>`;
					console.log(g);
					console.log(typeof(g));
					}
				
				
				for (att of attori) {
					console.log(att);
					a += `<p>${att.nome}</p>`;
					console.log(a);
					console.log(typeof(a));
					}
				
				s += `
				<tr>
      				<th scope="row">${i}</th>
      				<td>${film.titolo}</td>
      				<td>${film.anno}</td>
      				<td>${film.durata}</td>
      				<td>${film.regista}</td>
      				<td>${film.paese}</td>
      				<td>${film.lingua}</td>
      				<td>${a}</td>
      				<td>${g}</td>
      				<td>${film.locandina}</td>
      				<td>${film.trailer}</td>
					  <td style="overflow-y:scroll">${film.trama}</td>
      				<td><button class="btn btn-sm ms-1 pt-0" style="background-color: #FFD369!important; color: #222831; border-color: #393E46; onclick="filmUpdate(${film.id})"><i class="bi bi-pencil-square"></i></button></td>
      				<td><button class="btn btn-sm ms-1 pt-0" style="background-color: #FFD369!important; color: #222831; border-color: #393E46; onclick="filmDelete(${film.id})"><i class="bi bi-x"></i></button></td>
    			</tr>
			 	`;
			 	a="";
			 	g="";
			 		
			}
			
			s += `
			 		</tbody>
			 	</table>
				</div>
				
			 	`
			
			listTarget.innerHTML = s;
		});
}

function utentiList() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/admin/utenti/all")
		.then(res => res.json())
		.then(listaUtenti => {
			console.log(listaUtenti);
			i = 0;
			s = `
			<h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Lista Utenti</h3>

			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nickname</th>
						<th scope="col">Nome</th>
						<th scope="col">Cognome</th>
						<th scope="col">Data Di Nascita</th>
						<th scope="col">Email</th>
						<th scope="col">Password</th>
						<th scope="col">Telefono</th>
						<th scope="col">Attivo</th>
						<th scope="col">Ruoli</th>
						<th scope="col">Modifica</th>
						<th scope="col">Cancella</th>
					</tr>
				</thead>
				<tbody>
			 `;
			for (utente of listaUtenti) {
				i++;
				console.log(utente.ruoli);
				console.log(typeof(utente.ruoli));
				console.log
				let ruoliJSON = JSON.stringify(utente.ruoli);
				console.log(ruoliJSON);
			/*	let ruoli = JSON.parse(ruoliJSON);			non funziona per qualchè motivo
				
				for (ruo of ruoli) {
					console.log(ruo);
					 a += `<p>${ruo.nome}</p>`
					 console.log(a);
					 console.log(typeof(a));
				 }	*/
				s += `
				<tr>
      				<th scope="row">${i}</th>
      				<td>${utente.nickname}</td>
      				<td>${utente.nome}</td>
      				<td>${utente.cognome}</td>
      				<td>${utente.dataDiNascita}</td>
      				<td>${utente.email}</td>
      				<td>${utente.password}</td>
      				<td>${utente.telefono}</td>
      				<td>${utente.attivo}</td>
      				<td>${ruoliJSON}</td>
      				<td><button class="btn btn-sm ms-1 pt-0 bg-light" onclick="utenteUpdate(${utente.id})"><i class="bi bi-pencil-square"></i></button></td>
      				<td><button class="btn btn-sm ms-1 pt-0 bg-light" onclick="utenteDelete(${utente.id})"><i class="bi bi-x"></i></button></td>
    			</tr>
			 	`; 
			}
			s += `
			 		</tbody>
			 	</table>
			 	`
			listTarget.innerHTML = s;
		});
}

function ruoliList() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/lumiere/ruoli/all")
		.then(res => res.json())
		.then(listaRuoli => {
			console.log(listaRuoli);
			i = 0;
			s = `
			<h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Lista Ruoli</h3>

				<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nome Ruoli</th>
						<th scope="col">Modifica</th>
						<th scope="col">Cancella</th>
					</tr>
				</thead>
				<tbody>
			 	`;
			for (ruolo of listaRuoli) {
				i++;
				s += `
				<tr>
      				<th scope="row">${i}</th>
      				<td>${ruolo.nome}</td>
      				<td><button class="btn btn-sm ms-1 pt-0 bg-light" onclick="ruoloUpdate(${ruolo.id})"><i class="bi bi-pencil-square"></button></td>
      				<td><button class="btn btn-sm ms-1 pt-0 bg-light" onclick="ruoloDelete(${ruolo.id})"><i class="bi bi-x"></i></button></td>
    			</tr>
			 	`;
			}
			s += `
			 		</tbody>
			 	</table>
			 	`
			listTarget.innerHTML = s;
		});
}

function visualizzazioniList() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/lumiere/visualizzazioni/all")
		.then(res => res.json())
		.then(listaVisual => {
			console.log(listaVisual);
			i = 0;
			s = `
			<h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369"; >Lista Visualizzazioni</h3>

			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Data</th>
						<th scope="col">Numero</th>
						<th scope="col">Film</th>
						<th scope="col">Utente</th>
						<th scope="col">Modifica</th>
						<th scope="col">Cancella</th>
					</tr>
				</thead>
				<tbody>
			 	`;
			for (visual of listaVisual) {
				s += `
				<tr>
      				<th scope="row">${i}</th>
      				<td>${visual.data}</td>
      				<td>${visual.numero}</td>
      				<td>${visual.films}</td>
      				<td>${visual.utenti}</td>
      				<td><button class="btn btn-sm ms-1 pt-0 bg-light" onclick="visualizzazioneUpdate(${visual.id})"><i class="bi bi-pencil-square"></button></td>
      				<td><button class="btn btn-sm ms-1 pt-0 bg-light" onclick="visualizzazioneDelete(${visual.id})"><i class="bi bi-x"></i></button></td>
    			</tr>
			 	`;
			}
			s += `
			 		</tbody>
			 	</table>
			 	`
			listTarget.innerHTML = s;
		});
}

function genereDelete(id)
        {
            console.log("eliminazione id" + id);
            fetch("http://localhost:8080/api/v1/admin/genere/delete/" + id,
            {
                method: 'DELETE'
            })
            .then(generiList());
        }
        

function attoreDelete(id)
        {
            console.log("eliminazione id" + id);
            fetch("http://localhost:8080/api/v1/admin/attore/delete/" + id,
            {
                method: 'DELETE'
            })
            .then(attoriList());
        }
        
function filmDelete(id)
        {
            console.log("eliminazione id" + id);
            fetch("http://localhost:8080/api/v1/admin/film/delete/" + id,
            {
                method: 'DELETE'
            })
            .then(filmList());
        }
        
function utenteDelete(id)
        {
            console.log("eliminazione id" + id);
            fetch("http://localhost:8080/api/v1/admin/utente/delete/" + id,
            {
                method: 'DELETE'
            })
            .then(utentiList());
        }

function ruoloDelete(id)
        {
            console.log("eliminazione id" + id);
            fetch("http://localhost:8080/api/v1/admin/ruolo/delete/" + id,
            {
                method: 'DELETE'
            })
            .then(ruoliList());
        }
        
function visualizzazioneDelete(id)
        {
            console.log("eliminazione id" + id);
            fetch("http://localhost:8080/api/v1/admin/visualizzazione/delete/" + id,
            {
                method: 'DELETE'
            })
            .then(visualizzazioniList());
        }
        
function genereUpdate(id) {
	s = "";

	s = `
    <h3>Update Genere</h3>
	<form id="forma">
	<div class="mb-3">
		<label for="genere" class="form-label">Nome</label>
		<input type="text" class="form-control" id="genere">
	</div>
	<button type="submit" class="btn btn-primary"  style="background-color: #FFD369; color: #222831; border-color: #393E46;">Submit</button>
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


		fetch("http://localhost:8080/api/v1/admin/genere/update/" + id,
			{
				method: 'PUT',
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(newGenere)
			}
		)
			.then(generiList());
	})
}

function attoreUpdate(id) {
	s = "";

	s = `
    <h3>Update Attore</h3>
	<form id="forma">
	<div class="mb-3">
		<label for="attore" class="form-label">Nome</label>
		<input type="text" class="form-control" id="attore">
	</div>
	<button type="submit" class="btn btn-primary"  style="background-color: #FFD369; color: #222831; border-color: #393E46;">Submit</button>
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


		fetch("http://localhost:8080/api/v1/admin/attore/update/" + id,
			{
				method: 'PUT',
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(newAttore)
			}
		)
			.then(attoriList());
	})
}

function filmUpdate(id) {
	let s = "";
	let a = "";
	let g = "";
	
	
	const add = fetch("http://localhost:8080/api/v1/lumiere/generi/all")
		.then(res => res.json())
		.then(listaGeneri => {
		let a = "";
			console.log(listaGeneri);	   		
    		for (genere of listaGeneri) {
				
		a +=`
    			<option value="${genere.id}">${genere.nome}</option>
    			`
			}
  			
	console.log(a);
	return a;
	})
	a += add;
	console.log(a);
	s = `
    <h2 style ="font-weight:bold; margin-bottom: 1em; color: #FFD369">Update Film</h2>
	<form id="forma">
	<div class="mb-3">
		<label for="titolo" class="form-label">Titolo</label>
		<input type="text" class="form-control" id="titolo">
	</div>
	<div class="mb-3">
		<label for="trama" class="form-label">Descrizione</label>
		<input type="text" class="form-control" id="trama">
	</div>
	<div class="mb-3">
		<label for="locandina" class="form-label">Path Immagine</label>
		<input type="text" class="form-control" id="locandina">
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
	<div class="input-group mb-3">
		<label class="input-group-text" for="attoreOptions">Attore</label>
			<select class="form-select" id="attoreOptions">
				<option selected>Scegliere un genere</option>
			</select>
	</div>
	<div class="input-group mb-3">
		<label class="input-group-text" for="genereOptions">Genere</label>
			<select class="form-select" id="genereOptions">
				<option selected>Scegliere un genere</option>
				${a}
			</select>
	</div>
	
		
	<button type="submit" class="btn btn-primary" style="background-color: #FFD369; color: #222831; border-color: #393E46;">Submit</button>
	</form>
		`;

	formTarget.innerHTML = s;

	let formina = document.getElementById("forma");
	formina.addEventListener("submit", (e) => {
		e.preventDefault();

		let titolo = document.getElementById('titolo');
		let trama = document.getElementById('trama');
		let locandina = document.getElementById('locandina');
		let anno = document.getElementById('anno');
		let durata = document.getElementById('durata');
		let regista = document.getElementById('regista');
		let paese = document.getElementById('paese');
		let lingua = document.getElementById('lingua');

		console.log(typeof titolo.value)
		console.log(typeof trama.value)
		console.log(typeof locandina.value)
		console.log(locandina.value)
		console.log(typeof anno.value)
		console.log(anno.value)
		console.log(typeof durata.value)
		console.log(durata.value)
		console.log(typeof regista.value)
		console.log(typeof paese.value)
		console.log(typeof lingua.value)



		let newFilm = {
			"titolo": titolo.value,
			"trama": trama.value,
			"locandina": locandina.value,
			"anno": anno.value,
			"durata": durata.value,
			"regista": regista.value,
			"paese": paese.value,
			"lingua": lingua.value,
		};
		console.log(newFilm.value)


		fetch("http://localhost:8080/api/v1/admin/film/update/" + id,
			{
				method: 'PUT',
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(newFilm)
			}
		)
			.then(filmList());
	})
}

function utenteUpdate(id) {
	s = "";

	s = `
    <h3>Update Utente</h3>
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
	<button type="submit" class="btn btn-primary"  style="background-color: #FFD369; color: #222831; border-color: #393E46;">Submit</button>
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


		fetch("http://localhost:8080/api/v1/admin/utente/update/" + id,
			{
				method: 'PUT',
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(newUtente)
			}
		)
			.then(utentiList());
	})
}

function ruoloUpdate(id) {
	s = "";

	s = `
    <h3>Update Ruolo</h3>
	<form id="forma">
	<div class="mb-3">
		<label for="ruolo" class="form-label">Nome</label>
		<input type="text" class="form-control" id="ruolo">
	</div>
	<button type="submit" class="btn btn-primary" style="background-color: #FFD369; color: #222831; border-color: #393E46;">Submit</button>
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


		fetch("http://localhost:8080/api/v1/admin/ruolo/update/" + id,
			{
				method: 'PUT',
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(newRuolo)
			}
		)
			.then(ruoliList());
	})
}

function visualizzazioneUpdate(id) {
	s = "";

	s = `
    <h3>Update Visualizzazione</h3>
	<form id="forma">
	<div class="mb-3">
		<label for="data" class="form-label">Data</label>
		<input type="date" class="form-control" id="data">
		<label for="numero" class="form-label">Numero</label>
		<input type="text" class="form-control" id="numero">
	</div>
	<button type="submit" class="btn btn-primary" style="background-color: #FFD369; color: #222831; border-color: #393E46;">Submit</button>
	</form>
		`;

	formTarget.innerHTML = s;

	let formina = document.getElementById("forma");
	formina.addEventListener("submit", (e) => {
		e.preventDefault();

		let data = document.getElementById('data');
		let numero = document.getElementById('numero')

		console.log(typeof data.value)
		console.log(typeof numero.value)

		let newVisual = {
			 "data": data.value,
			 "numero" : numero.value
			  };
		console.log(newVisual.value)


		fetch("http://localhost:8080/api/v1/admin/visualizzazione/update/" + id,
			{
				method: 'PUT',
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(newVisual)
			}
		)
			.then(visualizzazioniList());
	})
}

