# case_itau_jogo_da_velha

Case proposto pelo itaú.

URL da AWS:
  http://jogodavelha-env.eba-3qfzmt59.sa-east-1.elasticbeanstalk.com/jogovelha
  
Documentação da API:
  http://jogodavelha-env.eba-3qfzmt59.sa-east-1.elasticbeanstalk.com/swagger-ui.html
  
Para lógica, foi feito o padrão de design "chain of responsability" no qual cada possibilidade de ganhar é um middleware.

Este projeto contem coverage de mais de 90% de testes unitários, stress test, container e tudo o que foi proposto.
