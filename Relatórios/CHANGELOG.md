## Alterações 09/11 - Raphael Leiva
### Added
- Adicionei uma classe para validar se um bilhete eletronico pode ser criado
- Adicionei um Decorator para a classe Parada para que passe a conter informações sobre status da viagem quando convém
- Criei a classe ViagemOnibus que extende a classe Viagem para que o código seja mais aberto a mudanças futuras
- Implementei um teste mockado na classe principal para demonstrar qual seria o fluxo de uso de um usuário ao selecionar uma viagem
- Implementei a interface Veiculo
- Implementei a lógica de um observador que atualiza os bilhetes eletronicos quando uma viagem passa pela parada de destino

### Changed
- Mudei bilhete eletrônico para que seja mais segura com seus atributos sendo `final`
- Mudei BilhetetEletronico para usar o método para validar antes de efetuar a criação
- Mudei a classe Onibus de forma que sirva para o propósito acordado com o grupo e implemente Veiculo
- Mudei a classe Parada de forma que sirva para o propósito acordado com o grupo
- Mudei a classe Viagem para ser abstrata e, portanto, mais genérica

### Fixed
