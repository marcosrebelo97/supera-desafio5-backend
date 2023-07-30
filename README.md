## API REST | Consultas em dados Bancários.

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

### Descrição 
- Este teste consiste em construir uma camada de serviço, para uma operação muito realizada em bancos, para emissão de extrato bancário.

### Requisitos e Funcionalidades do Projeto
- [x] A sua api deve fornecer os dados de transferência de acordo com o número da conta bacária.
- [x] Caso não seja informado nenhum filtro, retornar  todos os dados de transferência.
- [x] Caso seja informado um período de tempo, retornar todas as transferências relacionadas à aquele período de tempo.
- [x] Caso seja informado o nome do operador da transação, retornar todas as transferências relacionados à aquele operador.
- [x] Caso todos os filtros sejam informados, retornar todas as transferências com base no período de tempo informado e o nome do operador.
- [x] Operador de transação nada mais é que, o nome do responsável de destino da transação caso seja uma operação de transferência de saida ou o nome do responsável de onde se originou a transação caso seja uma operação de transferência de entrada.
- [x] Os valores devem ser de ponto flutuante, e deve-se considerar apenas duas casas decimais.
- [ ] O frontend deve seguir como exemplo o protótipo informado no documento do processo seletivo.
- [ ] No frontend o usuário deve ser capaz de informar um período de tem e/ou nome do operador da transasção como filtros para buscar as transações.
- [ ] As transações devem ser exibidas junto com o saldo total e o saldo total no período de acordo com o protótipo do documento.
