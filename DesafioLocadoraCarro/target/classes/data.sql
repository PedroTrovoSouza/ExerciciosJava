ALTER TABLE modelo_carro MODIFY categoria VARCHAR(255);

INSERT INTO modelo_carro (id_modelo, descricao, categoria)
VALUES (1, 'Sedan médio automático','SEDAN_MEDIO');

INSERT INTO carro (
    id_carro,
    chassi,
    cor,
    placa,
    valor_diaria,
    modelo_carro_id_modelo
) VALUES (
    1,
    '9BWZZZ377VT004251',
    'Preto',
    'ABC1D23',
    150.00,
    1
);

INSERT INTO acessorio (id_acessorio, descricao)
VALUES (1, 'Cilhos');

INSERT INTO carro_acessorio (id_carro, id_acessorio)
VALUES (1, 1);

INSERT INTO aluguel (
    data_pedido,
    data_entrega,
    data_devolucao,
    valor_total,
    id_carro
) VALUES (
    '2025-05-14',
    '2025-05-14',
    '2025-05-20',
    1200.50,
    1
);
