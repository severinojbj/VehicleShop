Para compilar:

- Na raiz do projeto (VehicleShop) executar a compilação:
javac -d build app/java/App.java

- Entrar na pasta com os compilados (build):
cd build

- Gerar o pacote executável (jar) com o comando:
jar -cmfe ..\META-INF\MANIFEST.MF App.jar app.java.App -C . .