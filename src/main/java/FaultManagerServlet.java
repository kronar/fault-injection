import com.google.common.base.Enums;
import com.google.common.base.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FaultManagerServlet extends HttpServlet {
    private FaultModeManager faultManager;

    public FaultManagerServlet(FaultModeManager fmm) {
        this.faultManager = fmm;
    }


    private enum FaultMode {
        ENABLED, DISABLED
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<FaultMode> mode = Enums.getIfPresent(FaultMode.class, req.getParameter("mode").toUpperCase());
        if (mode.isPresent()) {
            if (mode.get() == FaultMode.DISABLED) {
                faultManager.disable();
            } else {
                faultManager.enable();
            }
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        }
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
}
