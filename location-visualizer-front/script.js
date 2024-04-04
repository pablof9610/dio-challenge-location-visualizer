document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('cepForm').addEventListener('submit', function (event) {
        event.preventDefault()
        

        let cep = document.getElementById('cepInput').value
        
        let jsonData = {
            cep: cep
        }

        // log para debug
        console.log('Enviando requisição: ', jsonData)

        fetch('http://127.0.0.1:8080/visualization', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonData)
        })
        .catch(error => {
            console.log('Erro ao enviar requisição:', error)
        });

    });
});
