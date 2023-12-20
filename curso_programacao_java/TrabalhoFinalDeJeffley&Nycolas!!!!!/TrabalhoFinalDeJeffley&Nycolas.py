
class Aluno:
  nome = None
  cpf = None
  peso = 0
  altura = 0
  status = False
  imc = 0


class Exercicio:
  nomeAluno = None
  nomeExercicio = None
  numRepeticoes = 0
  pesoExercicio = 0


CadAlunos = []
treinoAlunos = []


def mostraLinha():
  print("-" * 30)
# Aqui fizermos o cadastro do aluno
def Cadastrar():
  cad = Aluno()
  cad.nome = input("Digite o nome do nosso novo aluno: ")
  cad.cpf = input("Digite o CPF do nosso novo aluno: ")
  if (len(cad.cpf)) != 11: # tratamento do cpf
    print("Cpf inválido")
    return
  else:
    cpf_formatado = f"{cad.cpf[:3]}.{cad.cpf[3:6]}.{cad.cpf[6:9]}-{cad.cpf[9:]}"
    cad.cpf = cpf_formatado
  cad.peso = float(input("Digite o peso: "))
  cad.altura = float(input("Digite a altura: "))
  cad.imc = cad.peso / (cad.altura**2)
  CadAlunos.append(cad)
  print("Cadastro com sucesso!")
  mostraLinha()

def Incluir(): # aqui nos incluirmos os treinos dos alunos cadastrados
  inc = Exercicio()
  mostraLinha()
  print("Bem-vindo aqui você pode incluir exercicio para os alunos")
  for i in range(1):
    find_name = input("Digite o nome do aluno que quer buscar: ")
    encontrado = []
    for aluno in CadAlunos:
      if aluno.nome == find_name:
        aluno.status = True
        encontrado.append(inc)
    if len(encontrado) == 0:
      print("Esse nome não está na lista de cadastro")
      return
    else:
      inc.nomeAluno = find_name
      inc.nomeExercicio = input("Digite o nome do exercício: ")
      inc.numRepeticoes = int(input("Digite o número de repetições: "))
      inc.peso = float(input("Digite o peso utilizado: "))
      treinoAlunos.append(inc)
      print("Inclusão realizada com sucesso")
      if len(treinoAlunos) >= 10:
        print("Limite de exercícios atingido!")
        return

def Alterar(): # aqui alteramos o nome dos exercicios segundo o nome do aluno!!!
  print("=" * 30)
  encontrado = []
  buscar = []
  find_name = input("Digite o nome do aluno que quer alterar o exercicio: ")
  for aluno in CadAlunos:
    if aluno.nome == find_name:
      encontrado.append(aluno)
  if len(encontrado) == 0:
    print("Esse nome não está na lista de cadastro")
    return
  else:
    nome_exo = input("Digite o nome do Exercicio que quer alterar: ")
    for i in treinoAlunos:
      if i.nomeAluno == find_name:
        buscar.append(i)
    if len(buscar) == 0:
        print("Esse aluno não tem treino")
    else:
      for k in treinoAlunos:
        if k.nomeExercicio == nome_exo:
          novo_nome = input("Digite o nome do exercicio: ")
          novo_cpf = input("Digite a repetição: ")
          novo_peso = int(input("Digite o  peso: "))
          k.nomeExercicio = novo_nome
          k.numRepeticoes = novo_cpf
          k.peso = novo_peso
          print("Atualização feita com sucesso")
          print()
          return

def Excluir1(): # Aqui excluimos um exercicio escolhido
  print("*" * 30)
  print("=" * 30)
  encontrado = []
  buscar = []
  find_name = input("Digite o nome do aluno que quer excluir o exercicio: ")

  for aluno in CadAlunos:
    if aluno.nome == find_name:
      encontrado.append(aluno)
  if len(encontrado) == 0:
    print("Esse nome não está na lista de cadastro")
    return
  else:
    nome_exo = input("Digite o nome do Exercicio que quer Excluir : ")
    for i in treinoAlunos:
      if i.nomeAluno == find_name:
        buscar.append(i)
    if len(buscar) == 0:
        print("Esse aluno não tem treino")
    else:
      for k in treinoAlunos:
        if k.nomeExercicio == nome_exo:
          treinoAlunos.remove(k)
          print("Excluído feito com sucesso")
          print()
          return

def ExcluirAll(): # Aqui excluimos todos os exercicios de um aluno sem excluir o aluno mesmo
  print("*" * 30)
  print("=" * 30)
  find_name = input("Digite o nome do aluno que quer buscar: ")
  c = 0
  while c < len(treinoAlunos):
    if treinoAlunos[c].nomeAluno == find_name:
      del treinoAlunos[c]
    else:
      c += 1
    if len(treinoAlunos) == c:
      for aluno in CadAlunos:
        if aluno.nome == find_name:
          aluno.status = False
          return
    print("Excluido feito com sucesso")

def Consultar(): # aqui podemos consultar um aluno cadastrado, as suas informações
  while True:
    find_name = input("Digite o nome do aluno que quer buscar: ")
    encontrado = []
    treino = []
    for aluno in CadAlunos:
      if aluno.nome == find_name:
        encontrado.append(aluno)
    if len(encontrado) == 0:  # Se nenhum aluno foi encontrado
      print("Esse nome não está na lista de cadastro")
      return

    else:
      for i in encontrado:  # percorre  dos alunos encontrados
        print("Nome: ", i.nome)
        print("CPF: ", i.cpf)
        print("Peso: ", i.peso)
        print("Altura: ", i.altura)
        print("Status: ", i.status)
        if i.imc >= 25:
          pesu = 'acima do peso'
        if i.imc < 18.5:
          pesu = 'abaixo do peso'
        else:
          pesu = 'peso normal'
        print(f"IMC: {i.imc:.2f}" )
        print('sua situacao de peso ideal é: ',pesu)
        mostraLinha()

    for k in treinoAlunos:
      if k.nomeAluno == find_name:
        treino.append(k)

    if len(treino) == 0:
      print("Esse aluno não tem treino cadastrado")
      return
    else:
      for k in treino:
        print("Nome do exercício: ", k.nomeExercicio)
        print("Número de repetições: ", k.numRepeticoes)
        print("Peso: ", k.peso)
        mostraLinha()
    resp = int(input("Digite qualquer número se tu quiser consultar mais aluno ou [000] se quiser parar "))
    if resp == 000:
      return

def Atualizar(): # atualizar o cadastro do aluno
  while True:
    find_name = input("Digite o nome do aluno que quer buscar: ")
    encontrado = []
    for aluno in CadAlunos:
      if aluno.nome == find_name:
        encontrado.append(aluno)
    if len(encontrado) == 0:
      print("Esse nome não está na lista de cadastro")
      return

    novo_nome = input("Digite o nome: ")
    novo_cpf = input("Digite o novo CPF: ")
    novo_peso = int(input("Digite o novo peso: "))
    nova_altura = float(input("Digite a nova altura: "))

    for aluno in encontrado:
      aluno.nome = novo_nome
      aluno.cpf = novo_cpf
      aluno.peso = novo_peso
      aluno.altura = nova_altura

    print("Atualização feita com sucesso")
    print()
    return

def Excluir():  # Excluir o cadastro do aluno e seu
   while True:
    find_name = input("Digite o nome do aluno que quer buscar: ")
    encontrado_cadastro = []
    encontrado_treino = []

    for aluno in CadAlunos:
      if aluno.nome == find_name:
        encontrado_cadastro.append(aluno)

    for aluno in treinoAlunos:
      if aluno.nomeAluno == find_name:
        encontrado_treino.append(aluno)

      if len(encontrado_treino) == 0:
        print("Este aluno não tem treino cadastrado!!!")
        print()
      else:
        for i in encontrado_treino:
          treinoAlunos.remove(i)
    if len(encontrado_cadastro) == 0:
      print("Esse nome não está na lista de cadastro")
      print()
      return
      k = Exercicio()
    else:
      for k in encontrado_cadastro:
        CadAlunos.remove(k)
        print("Excluir Aluno feito com sucesso")
        print()
        return
# relátorios de todos os alunos
def All_alunos():
  print("* A lista de alunos *")
  for i in CadAlunos:
    print("Nome: ",i.nome)
    print("CPF: ", i.cpf)
    print("Peso: ", i.peso)
    print("Altura: ", i.altura)
    print("status: ", i.status)
    mostraLinha()

#relatório dos alunos ativos
def Alunos_ativos():
  print("* A lista de alunos ativos *")
  for i in CadAlunos:
      if i.status == True:
        print("Nome:    ",i.nome)
        print("CPF:     ", i.cpf)
        print("Peso:    ", i.peso)
        print("Altura:  ", i.altura)
        print("status: ", i.status)
        mostraLinha()
      else:
       print("Não tem lista de aluno ativos")

# relaório dos alunos inativos
def Alunos_inativos():
  print("* A lista de Aluno Inativo *")
  for i in CadAlunos:
      if i.status == False:
        print("Nome: ", i.nome)
        print("CPF: ", i.cpf)
        print("Peso: ", i.peso)
        print("Altura: ", i.altura)
        print("status: ", i.status)
        mostraLinha()
      else:
       print("Não tem lista de aluno inativo")
#main
while True:
  print("Bem-vindo na Academia FITNESS JG")
  mostraLinha()
  print("1- Cadastrar aluno")
  print("2- Gerenciar aluno")
  print("3- Consultar aluno")
  print("4- Atualizar cadastro aluno")
  print("5- Excluir Aluno")
  print("6- Relatório de alunos")
  print("7- Sair")
  mostraLinha()
  administrar = int(input("escolhe uma opção para processa na Academia FITNESS JG:  "))

  if administrar == 1:
    Cadastrar()
    while True:
      adm = int(input("Quer Cadastrar mais alunos? [1:Sim 0:Não]: "))
      if adm == 1:
        Cadastrar()
      elif adm == 0:
        break
      else:
        print("Opção inválida, por favor digite somente 0 ou 1")

  elif administrar == 2:
      while True:
        print("1- Incluir Exercício")
        print("2- Alterar Exercício")
        print("3- Excluir um Exercício")
        print("4- Excluir todos os Exercícios")
        print("5- Voltar")
        Adm = int(input("Escolhe uma opção por gentileza: "))
        if Adm == 1:
            Incluir()
            while True:

              adm = int(input("Quer incluir mais treinos? [1:Sim 0:Não]: "))
              if adm == 1:
                Incluir()
              elif adm == 0:
                break
              else:
                print("Opção inválida, por favor digite somente 0 ou 1")

        elif Adm == 2:
            Alterar()
        elif Adm == 3:
            Excluir1()
        elif Adm == 4:
            ExcluirAll()
        elif Adm == 5:
          break
        else:
            print("Opção Inválido")

  elif administrar == 3:
    Consultar()
  elif administrar == 4:
    Atualizar()
  elif administrar == 5:
    Excluir()
  elif administrar == 6:
    while True:
      print("  **Relatório**")
      print("1- Todos os alunos")
      print("2- Alunos ativos")
      print("3- Alunos inativos")
      print("4- Voltar")
      adm = int(input("Escolhe uma opção para processa na Academia FITNESS JG:  "))
      if adm == 1:
        All_alunos()
      elif adm == 2:
        Alunos_ativos()
      elif adm == 3:
        Alunos_inativos()
      elif adm == 4:
        break
      else:
        print()
        print("opção inválida")
        print()

  elif administrar == 7:
    print("Volte sempre")
    break
  else:
      print("Opção inválida!")