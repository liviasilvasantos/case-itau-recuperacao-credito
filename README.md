# Case Itaú - Recuperação de Crédito

## Cenário Atual  
![Cenário Atual](./images/case-itau-cenario-atual.png?raw=true "Cenário Atual")

O cenário atual discorre de um sistema monolítico, com alto acoplamento e processamento batch.

Com codebase único e stack de tecnologias legadas, algumas limitações de aplicações monolíticas ficam evidentes:

- lentidão para atender demandas de alteração por conta do alto acoplamento;
- dificuldade para fazer deployment, já que uma pequena alteração exigirá deploy do todo e, normalmente, esses deploys tendem a demandar um esforço de várias equipes, já que a aplicação não é pequena;
- os testes em ambientes de homologação e produção tendem a ser muito custosos, por demandarem muito esforço, e possivelmente, demoraram muito tempo;
- a performance é comprometida pois todas as partes do sistema funcionam sob uma mesma stack, não havendo escolhas específicas para cada necessidade;
- o scale para momentos de maior demanda é comprometido pelo alto custo de recurso e esforço, tanto horizontal quanto verticalmente.

## Cenário Proposto  
![Cenário Proposto](./images/case-itau-cenario-proposto.png?raw=true "Cenário Proposto")

É possível combinar os padrões de arquitetura de microsserviços e orientado à eventos para que seja possível o desacoplamento das funcionalidades em aplicações menores e distribuídas. Com isso, obtemos alguns benefícios:

- escolha da melhor stack de tecnologia para cada parte do nosso negócio;
- codebase menor, permitindo que mais equipes possam trabalhar em partes diferentes do sistema;
- aplicações menores são mais fáceis de realizar testes específicos do negócio, e podem agilizar o deploy, sem precisar subir partes do sistema que nem foram alteradas;
- aplicações menores também permitem atuação pontual em casos de scale (up e down), utilizando apenas o recurso necessário, inclusive de forma automática através de ferramentas de CI/CD;
- a substituição de processamento em batch por jobs e stream de eventos permite que haja uma comunicação assíncrona entre as aplicações.

Alguns desafios, porém, surgem com o cenário proposto, e devem ser considerados:
- possibilidade de utilização de um cloud provider para alguns recursos, como banco de dados, filas, aplicações serverless e até arquivos na nuvem;
- utilização de um sistema de orquestração de containers em cluster, já disponível em vários cloud provideres;
- utilização de ferramentas de CI/CD para automizar o deploy das aplicações;
- utlização de ferramentas de observabilidade: métricas, logs, qualidade de teste.


## Fluxo
![Debt Renegotiation](./images/case-itau-flow.png?raw=true "Debt Renegotiation")

