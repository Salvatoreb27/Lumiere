
function visualizzaCarouselFilms(){
	console.log("visualizzazione");
	console
	fetch("http://localhost:8080/lumiere/films")
	.then(res => res.json())
	.then(listaFilms => 
	{
		console.log(listaFilms);
		s = ""
		for (film of listaFilms){

			s+= `<div class="carousel-item">
				<img src="./imagesAntonio/oppenheimer.jpg" class="d-block w-100" alt="babbeo">
		  		</div> `;

		
			/* s += `<div class="card" onclick="increaseLikes(${recensione.id})">
				<div class="d-flex justify-content-end">
				<button id="bottone" class="btn btn-sm position-absolute pt-0" onclick="elimina(${recensione.id})">x</button>
				</div>
				<h5 class="card-title ms-1 mt-1"> ${recensione.title} </h5> 
				<p class="testo-card ms-1 mt-1"> ${recensione.content} </p>
					</div> `; */
		}
		carouselSecondary.innerHTML = s;
		then.carouselSecondary.firstChild.classList.add('active');
	});
}

function addFilm(){
	console.log("add film");

	var newFilm = {"titolo": "Il pollo Mannaro", "anno": "12/07/2023", "durata": "6,30,50", "regista": "Salvatore Di Francia", "paese": "italia", "lingua": "italiano", "attori": "Salvatore Buono, Jack il pollo", "generi": "horror, action", "recensioni": null, "visualizzazioni": null };
	console.log(newFilm.value)

	fetch("http://localhost:8080/lumiere/films",{
		method: 'POST',
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(newFilm)
	}
	)
	.then(visualizzaCarouselFilms());
} 

/* 			this.titolo = titolo;
			this.anno = anno;
			this.durata = durata;
			this.regista = regista;
			this.paese = paese;
			this.lingua = lingua;
			this.attori = attori;
			this.generi = generi;
			this.recensioni = recensioni;
			this.visualizzazioni = visualizzazioni; */

