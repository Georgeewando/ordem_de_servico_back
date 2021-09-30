INSERT INTO tb_servidor (nome, telefone, email, senha)

VALUES ('Pedro Cavalcanti', '(67) 99999-8888', 'pedro@gmail.com', '123456');


INSERT INTO tb_servidor (nome, telefone, email, senha)

VALUES ('Maria Izabel', '(67) 99999-8887', 'maria@gmail.com', '234567');



INSERT INTO tb_ordem_de_servico ( equipamento, patrimonio, setor, descricao_problema,
data_cadastro, status, prioridade, descricao_solucao, servidor_id)

VALUES ('computador', '1234', 'CEREL', 'Não está ligando', '2021-08-01 09:30:00',
'PENDENTE', 'ALTA', '', 1);