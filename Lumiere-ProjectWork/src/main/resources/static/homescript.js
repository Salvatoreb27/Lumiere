
function visualizzaCarouselFilms() {
	console.log("visualizzazione");
	fetch("http://localhost:8080/api/v1/lumiere/films/all")
		.then(res => res.json())
		.then(listaFilms => {
			console.log(listaFilms);
			a = "";
			g = "";
			s = `
			<div id="carousel-2" class="carousel slide">
  				 <div class="carousel-inner">
  				  `
			
			
			for (film of listaFilms) {
				
				let generi =JSON.parse(JSON.stringify(film.generi));
				
					for (gen of generi) {
					g += `${gen.nome} `
					console.log(g);
				}

				a += `
				<div class="carousel-item active">
					<img src="./imagesAntonio/oppenheimer.jpg" class="d-block w-100" alt="babbeo">
		  			<div class="carousel-caption d-none d-md-block">
        				<h5>${film.titolo}</h5>
        				<p>${film.durata}</p>
        				<p>${g}</p>
      				</div>
		  		</div> `;
				
			}
			console.log(a);
			s += a;
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
			`
			console.log(s);
			carouselSecondary.innerHTML = s;

		
		/*	a.firstChild.classList.add("active");	*/
		});
}