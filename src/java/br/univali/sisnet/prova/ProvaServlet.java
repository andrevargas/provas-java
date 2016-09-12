
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
                provaCtrl.salvarProva(req);
                redirecionar(req, res, "detalheProva.jsp");
                break;
            case "realizar":
                break;
            case "listar":
                req.setAttribute("provas", provaCtrl.obterProvas());
                redirecionar(req, res, "listaProvas.jsp");
                break;
            case "visualizar":
                Prova prova = provaCtrl.obterProvaPorId(Integer.parseInt(req.getParameter("id")));
                req.setAttribute("prova", prova);
                redirecionar(req, res, "detalheProva.jsp");
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
