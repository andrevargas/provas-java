
package br.univali.sisnet.prova;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prova")
public class ProvaServlet extends HttpServlet {

   @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        verificarRequisicao(req, res);
    }

    private void verificarRequisicao(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        ProvaCtrl provaCtrl = new ProvaCtrl();

        switch (req.getParameter("acao")) {
            case "cadastrar":
                redirecionar(req, res, "cadastroProva.jsp?acao='cadastrar'");
                break;
            case "salvarCadastro":
                provaCtrl.salvarProva(req);
                redirecionar(req, res, "listaProvas.jsp?acao='listar'");
                break;
            case "realizar":
                if (!req.getParameter("id").equals("")) {
                    Prova prova = provaCtrl.obterProvaPorId(Integer.parseInt(req.getParameter("id")));
                    req.setAttribute("prova", prova);
                    redirecionar(req, res, "realizacaoProva.jsp?acao='realizar'");
                } else {
                    redirecionar(req, res, "index.jsp");
                }
                break;
            case "enviarRealizacao":
                if (!req.getParameter("idProva").equals("")) {
                    req.setAttribute("correcao", provaCtrl.realizarProva(req));
                    redirecionar(req, res, "detalheCorrecao.jsp");
                } else {
                    redirecionar(req, res, "index.jsp");
                }
                break;
            case "listar":
                req.setAttribute("provas", provaCtrl.obterProvas());
                redirecionar(req, res, "listaProvas.jsp?acao='listar'");
                break;
            default:
                break;

        }

    }

    private void redirecionar(HttpServletRequest req, HttpServletResponse res, String URI) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(URI);
        dispatcher.forward(req, res);
    }

}
