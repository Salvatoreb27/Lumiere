function generazioneVisualizzazione() {
	console.log("avvio generazione");
	let id = sessionStorage.filmId;

	fetch("http://localhost:8080/api/v1/lumiere/films/" + id)
		.then(res => res.json())
		.then(film => {
			console.log(film);
			s = "";
			a = "";
			g = "";
			att = "";
			gen = "";
			attoriList = "";
			trailer = "";
			
			
			console.log(film.trailer);
			let url = film.trailer.replace("watch?v=", "embed/");
			console.log(url)
			
			
			
			let attoriJSON = JSON.stringify(film.attori);
				console.log(attoriJSON);
				let attori = JSON.parse(attoriJSON);
				console.log(attori);
				let generiJSON = JSON.stringify(film.generi);
				console.log(generiJSON);
				let generi = JSON.parse(generiJSON);
				console.log(generi);
				
				for (gene of generi) {
					console.log(gene);
					gen += `<li>${gene.nome}</li>`;
					console.log(gen);
					console.log(typeof(gen));
					};
				
				
				for (atto of attori) {
					console.log(atto);
					att += `<li>${atto.nome}</li>`;
					console.log(att);
					console.log(typeof(att));
					};
			
			s = `
			<img id="immaginefilm" src="imagesAntonio/locandine/${film.locandina}" alt="Immagine film" class="mr-3" style="width:18rem" >
				<div class="media-body">
                	<h1 class="display-4">${film.titolo}</h1>
					<p>${film.trama}</p>
				</div>
			`;
			console.log(s);
			document.getElementById("mediaTarget").innerHTML = s;
			
			g = `
			<h2>Regia</h2>
			<p class="lead">${film.regista}</p>
			`;
			console.log(g);
			document.getElementById("registaTarget").innerHTML += g;
			
			attoriList = `
			<h2>Cast</h2>
			<ul>
			  ${att}
			</ul>
			`;
			console.log(attoriList);
			document.getElementById("attoriTarget").innerHTML += attoriList;
			
			trailerView = `
			<h2>Trailer</h2>
			<iframe width="560" height="315" src="${url}" frameborder="0"
            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			`;
			console.log(trailer);
			document.getElementById("trailerTarget").innerHTML += trailerView;
			});
}