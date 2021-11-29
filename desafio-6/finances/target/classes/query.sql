CREATE TABLE categorias (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE lancamentos (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(255),
	type VARCHAR(255),
	amount VARCHAR(255),
    date VARCHAR(255),
    paid BOOLEAN default false,
	categoryid BIGINT NOT NULL,
	FOREIGN KEY (categoryid)
	REFERENCES categorias(id)
	ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;


// Registro Categoria Exemplo
{ id: 1, name: 'Moradia', description: 'Pagamentos de Contas da Casa' },

// Registro Lançamento Exemplo
{ id: 1, name: 'Gás de Cozinha', paid: true, date: "14/10/2020", amount: "70,80", type: "expense", description: "Qualquer descrição para essa despesa", categoryId: 1 } as Lancamento,
{ id: 2, name: 'Aluguel', paid: false, date: "23/10/2020", amount: "15,00", type: "expense", categoryId: 1 } as Lancamento,
