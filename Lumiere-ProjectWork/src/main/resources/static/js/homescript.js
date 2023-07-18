
function visualizzaCarouselFilms() {
	console.log("visualizzazione");
	console
	fetch("http://localhost:8080/lumiere/films/all")
		.then(res => res.json())
		.then(listaFilms => {
			console.log(listaFilms);
			s = `<div id="carouselExampleCaptions" class="carousel slide">
  				 <div class="carousel-inner"> `
			
			
			for (film of listaFilms) {
				
				let generiJSON = JSON.stringify(film.generi);
				let generi = JSON.parse(generiJSON);

				a += `
				<div class="carousel-item">
					<img src="./imagesAntonio/oppenheimer.jpg" class="d-block w-100" alt="babbeo">
		  			<div class="carousel-caption d-none d-md-block">
        				<h5>${film.titolo}</h5>
        				<p>${film.durata}</p>
        				<p>${g}</p>
      				</div>
		  		</div> `;
				
				for (gen of generi) {
					console.log(g);
					g += `${gen.nome}`
				}
				
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
