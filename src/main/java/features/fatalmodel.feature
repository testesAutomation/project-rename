# encoding: utf-8
# language: pt

Funcionalidade: Login e editar cadastro

  Contexto:
    Dado que o usuário navega até o site da fatalmodels

Esquema do Cenario: Fazer login como acompanhante
  Quando o usuário faz login como ‘acompanhante' usando telefone "<telefone>" e senha "<senha>"
  Então o login deve ser bem sucedido
  Exemplos:
  | telefone     |senha            |
  |(61)99999-9999| fatalmodel2019  |

Esquema do Cenario: Fazer login como acompanhante utilizando uma senha incorreta
  Quando o usuário faz login como ‘acompanhante' usando telefone "<telefone>" e senha "<senha>"
  Então mensagem de senha incorreta deverá ser  apresentada
  Exemplos:
  | telefone     |senha                |
  |(61)99999-9999| senhaincorreta2019  |


Esquema do Cenario: Fazer login como acompanhante desmarcando a opção "mantenha-me conectado"
  Quando o usuário faz login como ‘acompanhante' usando telefone "<telefone>" e senha "<senha>"
  E a caixa 'mantenha-me conectado’ desmarcada
  Então o login deve ser bem sucedido
  Exemplos:
  | telefone     |senha                |
  |(61)99999-9999| fatalmodel2019  |
