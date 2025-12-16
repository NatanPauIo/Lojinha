package jobs;

import models.Avaliacao;
import models.Pessoa;
import models.Produto;
import models.Status;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {
	@Override
	public void doJob() throws Exception {
		if (Produto.count() == 0) {
			Produto p1 = new Produto("Bracelete Mola Dourado", "Design moderno e versátil em mola, banhado a ouro 18k. Se ajusta perfeitamente ao pulso.", 75.0, Status.ATIVO, "/public/images/joia1.jpg");
			Produto p2 = new Produto("Brincos Nó", "Par de brincos clássicos em formato de nó. Disponível em dourado e prateado.", 50.0, Status.ATIVO, "/public/images/joia2.jpg");
			Produto p3 = new Produto("Conjunto Trevo Prata", "Conjunto completo com choker, brincos e pulseira. Pingente de trevo cravejado de zircônias.", 249.90, Status.ATIVO, "/public/images/joia3.jpg");
			Produto p4 = new Produto("Conjunto Flor Vazada", "Conjunto delicado de flor com design vazado e acabamento escovado, banhado a ouro.", 129.90, Status.ATIVO, "/public/images/joia4.jpg");
			Produto p5 = new Produto("Conjunto Coração Vazado", "Kit com colar e brincos de coração com design vazado em filetes, super leve e estiloso.", 115.0, Status.ATIVO, "/public/images/joia5.jpg");
			Produto p6 = new Produto("Conjunto Flor Lisa", "Conjunto de flor com acabamento liso e escovado. Minimalista e perfeito para o dia a dia.", 125.0, Status.ATIVO, "/public/images/joia6.jpg");
			Produto p7 = new Produto("Conjunto Maxi Coração Dourado", "Conjunto de impacto com choker e pingente de coração, brincos e mix de pulseiras.", 269.90, Status.ATIVO, "/public/images/joia7.jpg");
			Produto p8 = new Produto("Conjunto Coração Amassado", "Conjunto de colar e brincos de coração com textura amassada, banhado a ouro 18k.", 139.0, Status.ATIVO, "/public/images/joia8.jpg");
			Produto p9 = new Produto("Mix Colares e Brinco Pizza", "Mix com colar fita laminada e colar com pingente 'S' cravejado, acompanhado de brinco pizza.", 189.90, Status.ATIVO, "/public/images/joia9.jpg");

			p1.save();
			p2.save();
			p3.save();
			p4.save();
			p5.save();
			p6.save();
			p7.save();
			p8.save();
			p9.save();
			
			// --- Avaliações para o Produto 1 (Bracelete Mola Dourado) ---
			Avaliacao avaliacao1 = new Avaliacao("Peça super versátil, consigo usar em várias ocasiões. Amei a compra.", "Gabriela Lima", p1);
			Avaliacao avaliacao2 = new Avaliacao("Gostei muito do material, parece ser bem resistente. Ótimo custo-benefício.", "Lucas Martins", p1);
			avaliacao1.save();
			avaliacao2.save();

			// --- Avaliações para o Produto 2 (Brincos Nó) ---
			Avaliacao avaliacao3 = new Avaliacao("Adorei! Produto de ótima qualidade e entrega rápida.", "Isabela Ferreira", p2);
			Avaliacao avaliacao4 = new Avaliacao("Segunda compra na loja e mais uma vez satisfeita. Os brincos de nó são um clássico.", "Amanda Pereira", p2);
			Avaliacao avaliacao5 = new Avaliacao("Muito bonito e elegante. Recomendo.", "Thiago Souza", p2);
			avaliacao3.save();
			avaliacao4.save();
			avaliacao5.save();

			// --- Avaliações para o Produto 3 (Conjunto Trevo Prata) ---
			Avaliacao avaliacao6 = new Avaliacao("Foi um presente e a pessoa adorou. Peça muito bonita e delicada.", "Rafael Oliveira", p3);
			Avaliacao avaliacao7 = new Avaliacao("O acabamento é impecável, exatamente como na foto. Superou minhas expectativas.", "Larissa Costa", p3);
			Avaliacao avaliacao8 = new Avaliacao("Brilha muito! Chegou bem embalado e no prazo certo.", "Vinicius Gomes", p3);
			avaliacao6.save();
			avaliacao7.save();
			avaliacao8.save();

			// --- Avaliação para o Produto 4 (Conjunto Flor Vazada) ---
			Avaliacao avaliacao9 = new Avaliacao("Simplesmente perfeito! Qualidade excelente e design maravilhoso.", "Sofia Ribeiro", p4);
			avaliacao9.save();

			// --- Avaliações para o Produto 5 (Conjunto Coração Vazado) ---
			Avaliacao avaliacao10 = new Avaliacao("Mais bonito pessoalmente do que nas fotos. Comprarei mais vezes com certeza.", "Carolina Almeida", p5);
			Avaliacao avaliacao11 = new Avaliacao("Atendimento nota 10! Tiraram todas as minhas dúvidas antes da compra. O produto é lindo.", "Felipe Castro", p5);
			avaliacao10.save();
			avaliacao11.save();

			// --- Avaliação para o Produto 6 (Conjunto Flor Lisa) ---
			Avaliacao avaliacao12 = new Avaliacao("Peça super delicada e minimalista, exatamente o que eu procurava. Amei!", "Letícia Barbosa", p6);
			avaliacao12.save();

			// --- Avaliações para o Produto 7 (Conjunto Maxi Coração Dourado) ---
			Avaliacao avaliacao13 = new Avaliacao("Conjunto poderoso! O coração é grande e chama a atenção. Qualidade excelente.", "Matheus Carvalho", p7);
			Avaliacao avaliacao14 = new Avaliacao("Chegou no prazo, tudo certinho. O conjunto é de impacto, perfeito para festas.", "Juliana Moraes", p7);
			avaliacao13.save();
			avaliacao14.save();

			// --- Avaliação para o Produto 8 (Conjunto Coração Amassado) ---
			Avaliacao avaliacao15 = new Avaliacao("A textura amassada é o charme da peça. Muito diferente e estiloso. Gostei muito!", "Bruno Rodrigues", p8);
			avaliacao15.save();

			// --- Avaliações para o Produto 9 (Mix Colares e Brinco Pizza) ---
			Avaliacao avaliacao16 = new Avaliacao("Amei o mix de colares, dá pra usar de várias formas. Muito prático!", "Patrícia Nogueira", p9);
			Avaliacao avaliacao17 = new Avaliacao("O brinco pizza é um clássico, e os colares complementam super bem. Ótima compra.", "Daniel Costa", p9);
			Avaliacao avaliacao18 = new Avaliacao("Qualidade muito boa pelo preço. Recomendo a loja e os produtos.", "Sandra Mello", p9);
			avaliacao16.save();
			avaliacao17.save();
			avaliacao18.save();

			// Criando usuários para teste
			Pessoa laura = new Pessoa();
			laura.nome = "LAURA";
			laura.email = "la@gmail.com";
			laura.senha = "12345";
			laura.login = "lauraataliba";
			laura.status = Status.ATIVO;
			laura.save();
			
			Pessoa elokim = new Pessoa();
			elokim.nome = "ELO";
			elokim.email = "elo@gmail.com";
			elokim.senha = "6789";
			elokim.login = "eloize";
			elokim.status = Status.ATIVO;
			elokim.save();
		}
	}
}