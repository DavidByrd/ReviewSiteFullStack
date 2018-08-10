var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
        
        const res = JSON.parse(xhr.response)
        const container = document.querySelector('.container')

        console.log({res})

        res.forEach(function(course) {
        	const comicItem = document.createElement('div')

        	const name = document.createElement('h2')
        	name.innerText = comic.title;

        	container.appendChild(tagItem)
        	nameItem.appendChild(title);
        });
    }
}


xhr.open('GET', 'https://localhost:8080/names',true);


xhr.send();