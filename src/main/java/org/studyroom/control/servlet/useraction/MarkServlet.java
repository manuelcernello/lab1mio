package org.studyroom.control.servlet.useraction;

import org.studyroom.control.dao.AnswerDao;
import org.studyroom.control.utilities.HibernateUtil;
import org.studyroom.model.entities.Answer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 08/05/2014
 * Time: 18:46
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "MarkServlet", urlPatterns = {"/mark"})
public class MarkServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long answerID = Long.parseLong(req.getQueryString().replaceFirst("a=", ""));
        Answer answer = AnswerDao.getInstance().getAnswer(HibernateUtil.getGuestSession(), answerID);
        answer.setMarked(true);
        AnswerDao.getInstance().addAnswer(HibernateUtil.getGuestSession(), answer);
        resp.sendRedirect("/studyroom/goTo?goto&q=" + answer.getQuestion().getId());
    }
}