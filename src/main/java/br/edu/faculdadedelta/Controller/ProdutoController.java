package br.edu.faculdadedelta.Controller;

import br.edu.faculdadedelta.dao.ProdutoJpaDAO;
//ProdutoControlle
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import br.edu.faculdadedelta.modelo.Produto;
public class ProdutoController {
        private Produto produto;
        private DataModel model;
        public ProdutoController() {
                produto = new Produto();
        }

        public Produto getProduto() {
                return produto;
        }
        public void setProduto(Produto produto) {
                this.produto = produto;
        }

        public String salvar(){
                ProdutoJpaDAO produtodao = new ProdutoJpaDAO();
                        produtodao.salvar(produto);
                return "salvar";
        }
        public DataModel getTodos(){
        	ProdutoJpaDAO produtodao = new ProdutoJpaDAO();
                       model = new ListDataModel(produtodao.exibir());
                return model;
        }}
