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
			attoriList = "";
			trailer = "";
			
			
			
			
			
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
			<img id="immaginefilm" src="${film.locandina}" alt="Immagine film" class="mr-3" width="100" height="100">
			`;
			document.getElementById("immagineTarget").innerHTML = s;
			
			
			a = `
			<h1 class="display-4">${film.titolo}</h1>
			<p class="lead">Un film diretto da ${film.regista}</p>
			`;
			console.log(a);
			document.getElementById("dettagliTarget").innerHTML = a;
			
			g = `
			<h2>Trama</h2>
			<p>${film.trama}</p>
			`
			document.getElementById("tramaTarget").innerHTML = g;
			
			attoriList = `
			<h2>Cast</h2>
			<ul>
			  ${att}
			</ul>
			`
			document.getElementById("attoriTarget").innerHTML = attoriList;
			
			trailer = `
			<h2>Trailer</h2>
			<iframe width="560" height="315" src="${film.trailer}" frameborder="0"
            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
			`
			document.getElementById("trailerTarget").innerHTML = trailer;
			});
}