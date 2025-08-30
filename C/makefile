folder:
	@echo -e "Criando pasta para o exercício $(N)..."
	@mkdir -p ex$(N)/assets/;
	@mkdir -p ex$(N)/pubs/;
	@mkdir -p ex$(N)/build/;
	@touch ex$(N)/main.c;
	@nvim ex$(N)/pubs/pub.in;
	@nvim ex$(N)/pubs/pub.out;
	@echo -e "Pasta criada."

run: compile
	@echo -e "Iniciando execução...\n"
	@./ex$(N)/exec < ./ex$(N)/pubs/pub.in;

test: compile
	@echo -e "Iniciando teste de programa...\n"
	@./ex$(N)/exec < ./ex$(N)/pubs/pub.in > ./ex$(N)/saida.out;
	@nvim -d ./ex$(N)/saida.out ./ex$(N)/pubs/pub.out;

compile: 
	@echo -e "Iniciando compilação..."
	@gcc -c ex$(N)/main.c;
	@gcc -c ex$(N)/assets/*.c;
	@mv *.o ex$(N)/build
	@gcc ex$(N)/build/*.o -o ex$(N)/exec;
	@echo -e "Compilação finalizada."

clear: 
	@echo -e "Iniciando limpeza do exercicio..."
	@-rm ./ex$(N)/*.out ./ex$(N)/exec ./ex$(N)/build/*
	@echo -e "Limpeza finalizada."
