
function visualizzaCarouselFilms() {
	console.log("visualizzazione");
	fetch("http://localhost:8080/api/v1/lumiere/films/all")
		.then(res => res.json())
		.then(listaFilms => {
			console.log(listaFilms);
			let i = 0;
			let n = 0;
			let a = "";
			let g = "";
			let t = "";
			let c = "";
			let s = `
			<div id="carousel-2" class="carousel slide">
  				 <div class="carousel-inner">
  				  `
			
			
			for (film of listaFilms) {
					i ++;
				let generi =JSON.parse(JSON.stringify(film.generi));
					
					for (gen of generi) {
					g += `${gen.nome} `
					console.log(g);
				}
				
				a += `
					<div class="col col-md-6 col-lg-3">
						<div class="card" style="width: 16em;">
       						<img src="imagesAntonio/locandine/${film.locandina}" alt="...">
        					<div class="card-body">
          						<h5 class="card-title mb-2 fs-6">${film.titolo}</h5>
          						<p class="card-text mb-2 fs-6">${g} </p>
           						<p class="card-text mb-0 fs-6">Minuti ${film.durata}</p>
           						<div class="card-footer pb-0">
           							<div class="d-grid gap-2 col-12 mx-">
										<button type="button" onclick="paginaFilm('${film.id}')" class="btn btn-sm btn-warning">Guarda</button>
         							</div>
        						</div>
      						</div>
    					</div>
    				</div>
				`
			/*
				a += `
				<div class="carousel-item ${c}">
					<img src="./imagesAntonio/oppenheimer.jpg" class="d-block w-100" alt="babbeo">
		  			<div class="carousel-caption d-none d-md-block">
        				<h5>${film.titolo}</h5>
        				<p>${film.durata}</p>
        				<p>${g}</p>
      				</div>
		  		</div> `;
				*/
				
			if (i && !(i % 4)) {
				n++;
					if (n===1) {
						c = `active`;
					} else {
						c = "";
					}
					
						t = `
						<div class="carousel-item ${c}">
							<div class="row">
								${a}
							</div>
						</div>
							`
						
						a = ` `;
						s += t;
						i = 0;
			};
			
			g = "";
			
			}
			
			if (i != 0) {
				s += `
						<div class="carousel-item">
							<div class="row">
								${a}
							</div>
						</div>
							`
			}
			
			
			s += `
						</div>
 							<button class="carousel-control-prev" type="button" data-bs-target="#carousel-2" data-bs-slide="prev">
    							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    							<span class="visually-hidden">Previous</span>
  							</button>
  							<button class="carousel-control-next" type="button" data-bs-target="#carousel-2" data-bs-slide="next">
   								<span class="carousel-control-next-icon" aria-hidden="true"></span>
    							<span class="visually-hidden">Next</span>
  							</button>
						</div>
					</div>
				</div>
			`;
			console.log(s);
			carouselSecondary.innerHTML = s;

		

	});

}


function generazioneDropdownGeneri() {
	console.log("avvio lista");

	fetch("http://localhost:8080/api/v1/lumiere/generi/all")
		.then(res => res.json())
		.then(listaGeneri => {
			console.log(listaGeneri);
			s = `
				
			 	`;
			for (genere of listaGeneri) {
				console.log(genere.nome)
				console.log(typeof(genere.nome))
				s += `
				<li><button class="dropdown-item" onclick="ricercaPerGenere('${genere.nome}')">${genere.nome}</li>
			 	`;
			}
			dropdownTarget.innerHTML = s;
		});
}


function ricercaPerGenere(nome) {
	console.log(nome);
	console.log(typeof(nome));
	let n = document.getElementById("refreshTarget");	
	n.remove();
	
	console.log("visualizzazione");
	fetch("http://localhost:8080/api/v1/lumiere/films/genere/" + nome)
		.then(res => res.json())
		.then(listaFilms => {
				console.log("listaFilmFiltrati");
				g = ""
				s = `
				<main id="refreshTarget">
					<div id="pietro"
				`
				
				for (film of listaFilms) {
				let generi =JSON.parse(JSON.stringify(film.generi));
					
					for (gen of generi) {
					g += `${gen.nome} `
					console.log(g);
				}
				
				
				s += `
				<div class="card" style="width: 16em;">
       						<img src="${film.locandina}" class="card-img-top" alt="Locandina del film">
        					<div class="card-body">
          						<h5 class="card-title mb-2 fs-6">${film.titolo}</h5>
          						<p class="card-text mb-2 fs-6">${g} </p>
           						<p class="card-text mb-0 fs-6">Minuti ${film.durata}</p>
           						<div class="card-footer pb-0">
           							<div class="d-grid gap-2 col-12 mx-">
										<button type="button" onclick="paginaFilm('${film.id}')" class="btn btn-sm btn-warning">Guarda</button>
         							</div>
        						</div>
      						</div>
    					</div>
				`
				
				g = "";
				}
				
				s += `
				</div>
				</main>
				`
				console.log(s)
				refreshComplete.innerHTML = s;
			});
	
}

function paginaFilm(id) {
	sessionStorage.filmId = id;
	window.location = "./visualizzazioneFilm.html"
}

function dettaglioFilm(id) {
	console.log(id);
	let n = document.getElementById("refreshTarget");	
	n.remove();
	
	console.log("visualizzazione");
	fetch("http://localhost:8080/api/v1/lumiere/films/" + id)
		.then(res => res.json())
		.then(film => {
			console.log("film al dettaglio");
			
			s = "";
			a = "";
			g = "";
			
			
			let generi =JSON.parse(JSON.stringify(film.generi));
					
					for (gen of generi) {
					g += `<p>${gen.nome}</p>`
					console.log(g);
				}
				
			let attori =JSON.parse(JSON.stringify(film.attori));
					
					for (att of attori) {
					a += `<p>${att.nome}</p>`
					console.log(g);
				}	
			
			
			
			s = `
			<main id="refreshTarget">
				<div class = "row">
					<div class = "col-6">
					<img src = "${film.locandina}" alt = "Immagine del film">
					<h2>${film.titolo}</h2>
					</div>
					<div class = "col-6">
					<p>${film.trama}</p>
					</div>
				</div>
				<div class = "row">
					<div class = "col-2">
					<p>Durata in minuti</p>
					<p>${film.durata}</p>
					</div>
					<div class = "col-2">
					<p>Lingua Originale</p>
					<p>${film.anno}</p>
					</div>
					<div class = "col-2">
					<p>Lingua Originale</p>
					<p>${film.lingua}</p>
					</div>
					<div class = "col-2">
					<p>Paese di produzione</p>
					<p>${film.paese}</p>
					</div>
					<div class = "col-2">
					<p>Paese di produzione</p>
					<p>${film.regista}</p>
					</div>
					<div class = "col-2">
						<div class = "row">
							<div class = "col-6">
								<p>Attori</p>
								${a}
							</div>
							<div class = "col-6">
								<p>Generi</p>
								${g}
							</div>
						</div>
					</div>
				</div>
			</main>
			`
			console.log(s)
			refreshComplete.innerHTML = s;
			});
}

// __________________________________________________________

  function redirectToPage() {
    window.location.href = "HomeXGenere.html";
  }
  function changePage() {
      let dropdown = document.getElementById("myDropdown");
      let selectedValue = dropdown.value;
      console.log(typeof(dropdown.value))
      let titolo = document.getElementById("dropdown-item");
      let contenuto = document.getElementById("contenuto");

      if (selectedValue === "Avventura") {
		  console.log("success");
        titolo.innerHTML = "Film Di Avventura";
        contenuto.innerHTML = "<p>Contenuto per l'opzione 1</p>";
      } else if (selectedValue === "opzione2") {
        titolo.innerHTML = "Opzione 2 selezionata";
        contenuto.innerHTML = "<p>Contenuto per l'opzione 2</p>";
      } else if (selectedValue === "opzione3") {
        titolo.innerHTML = "Opzione 3 selezionata";
        contenuto.innerHTML = "<p>Contenuto per l'opzione 3</p>";
      }
    }


function visualizzaFilmPerGenere (genere) {
	console.log("success");
	
	document.getElementById("BannerFilm").style.display = "none";
	let s = `  <div class="container text-center">
  <div class="row">
    <div class="col">
      ${genere}
    </div>
    <div class="col">
      ${genere}
    </div>
    <div class="col">
      ${genere}
    </div>
  </div>
</div>`
    document.getElementById("listaFilmPerGenere").innerHTML = s;
}

