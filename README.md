# dio-project-patterns-spring-challenge

Para este desafio escolhi reproduzir parte do que vi em aula, mas adicionalmente o projeto é integrado com o Google Static Map APi usando o Feign para mostrar a região que aquele CEP corresponde.

1. Basicamente, temos um front-end que pede por um CEP e altera a imagem estática no diretório para o qual temos uma tag img apontando:

![image](https://github.com/pablof9610/dio-challenge-location-visualizer/blob/main/assets/1.png)
![image](https://github.com/pablof9610/dio-challenge-location-visualizer/blob/main/assets/2.png)

2. Ao clicar no botão, é acionada a função que esperava esta ação, fazendo uma requisição para o back-end em java através do fetch, apontando para o endpoint que no caso é o localhost:

![image](https://github.com/pablof9610/dio-challenge-location-visualizer/blob/main/assets/3.png)

3. Ao chegar no back-end, o VisualizationController vai fazer o trabalho de receber aquela requisição passando o CEP informado para um objeto Endereco.
Em seguida, é chamado o método mountImageFromBytes que passa o objeto preenchido apenas com o CEP.

![image](https://github.com/pablof9610/dio-challenge-location-visualizer/blob/main/assets/4.png)

(OBS: A anotação @CrossOrigin é necessária para permitir requisições vindo do localhost front-end na porta 5500)

4. Dentro da Implementação MapServiceImpl é feita uma chamada à API do ViaCep para completar os demais campos do objeto Endereco, retornando um toString formando o endereço completo.
Em seguida, é feita uma chamada GET à API do Google através do método googleMapsService.*getStaticMapImage*:

![image](https://github.com/pablof9610/dio-challenge-location-visualizer/blob/main/assets/5.png)

Este processo obtém de volta uma imagem em um array de bytes, a qual é montada através do metodo read do ImageIO para um objeto Buffered Image.

Após isso é escrita no disco na pasta do front-end.



