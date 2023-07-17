
function visualizzaCarouselFilms() {
	console.log("visualizzazione");
	console
	fetch("http://localhost:8080/lumiere/films/all")
		.then(res => res.json())
		.then(listaFilms => {
			console.log(listaFilms);
			s = `<div id="carouselExample" class="carousel slide">
  				 <div class="carousel-inner"> `
			
			
			for (film of listaFilms) {

				a += `<div class="carousel-item">
				<img src="./imagesAntonio/oppenheimer.jpg" class="d-block w-100" alt="babbeo">
		  		</div> `;


				/* s += `<div class="card" onclick="increaseLikes(${recensione.id})">
					<div class="d-flex justify-content-end">
					<button id="bottone" class="btn btn-sm position-absolute pt-0" onclick="elimina(${recensione.id})">x</button>
					</div>
					<h5 class="card-title ms-1 mt-1"> ${recensione.title} </h5> 
					<p class="testo-card ms-1 mt-1"> ${recensione.content} </p>
						</div> `; 
						
						
						
<div id="carouselExample" class="carousel slide">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="..." class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="..." class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="..." class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
						*/
			}
			s += a;
			s += `
				</div>
 				<button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
   					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    				<span class="visually-hidden">Previous</span>
  				</button>
  				<button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    				<span class="carousel-control-next-icon" aria-hidden="true"></span>
    				<span class="visually-hidden">Next</span>
  				</button>
			</div>
			`
			
			carouselSecondary.innerHTML = s;
			then.a.firstChild.classList.add('active');
		});
}