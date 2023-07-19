
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
       						<img src="./imagesAntonio/locandine/taxi-driver.png" class="card-img-top" alt="...">
        					<div class="card-body">
          						<h5 class="card-title mb-2 fs-6">${film.titolo}</h5>
          						<p class="card-text mb-2 fs-6">${g} </p>
           						<p class="card-text mb-0 fs-6">Minuti ${film.durata}</p>
           						<div class="card-footer pb-0">
           							<div class="d-grid gap-2 col-12 mx-">
										<button type="button" class="btn btn-sm btn-warning">Guarda</button>
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
						
						a = ` `
						s += t;
			};
			
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



function visualizzaCarouselFilmsmulti() {
	console.log("visualizzazione");
	fetch("http://localhost:8080/api/v1/lumiere/films/all")
		.then(res => res.json())
		.then(listaFilms => {
			s = "";
			a = "";
			
			let i = 0;
			for (film of listaFilms) {
				i++;
				console.log(i);
				a += `<h5>${film.titolo}</h5>`
				console.log(a);
				
					if (i && !(i % 2)) {
						s = `
						<div>
							${a}
						</div>
							`
						
						a = ` `
			
					console.log(s);
					pollo.innerHTML += s;	
					}
				}
			
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
				`
				
				for (film of listaFilms) {
				let generi =JSON.parse(JSON.stringify(film.generi));
					
					for (gen of generi) {
					g += `${gen.nome} `
					console.log(g);
				}
				
				
				s += `
				<div class="card" style="width: 16em;">
       						<img src="./imagesAntonio/locandine/taxi-driver.png" class="card-img-top" alt="...">
        					<div class="card-body">
          						<h5 class="card-title mb-2 fs-6">${film.titolo}</h5>
          						<p class="card-text mb-2 fs-6">${g} </p>
           						<p class="card-text mb-0 fs-6">Minuti ${film.durata}</p>
           						<div class="card-footer pb-0">
           							<div class="d-grid gap-2 col-12 mx-">
										<button type="button" class="btn btn-sm btn-warning">Guarda</button>
         							</div>
        						</div>
      						</div>
    					</div>
				`
				}
				
				s += `
				</main>
				`
				console.log(s)
				refreshComplete.innerHTML = s;
			});
	
}

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

