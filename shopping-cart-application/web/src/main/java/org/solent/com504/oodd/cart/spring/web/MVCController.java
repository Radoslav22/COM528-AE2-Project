package org.solent.com504.oodd.cart.spring.web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.oodd.cart.model.dto.ShoppingItem;
import org.solent.com504.oodd.cart.model.dto.User;
import org.solent.com504.oodd.cart.model.dto.UserRole;
import org.solent.com504.oodd.cart.model.service.ShoppingCart;
import org.solent.com504.oodd.cart.model.service.ShoppingService;
import org.solent.com504.oodd.cart.web.WebObjectFactory;
import org.solent.com504.oodd.cart.web.PropertiesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MVCController {

    final static Logger LOG = LogManager.getLogger(MVCController.class);

    // this could be done with an autowired bean
    //private ShoppingService shoppingService = WebObjectFactory.getShoppingService();
    @Autowired
    ShoppingService shoppingService = null;

    // note that scope is session in configuration
    // so the shopping cart is unique for each web session
    @Autowired
    ShoppingCart shoppingCart = null;

    private User getSessionUser(HttpSession session) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            sessionUser = new User();
            sessionUser.setUsername("anonymous");
            sessionUser.setUserRole(UserRole.ANONYMOUS);
            session.setAttribute("sessionUser", sessionUser);
        }
        return sessionUser;
    }

    // this redirects calls to the root of our application to index.html
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(Model model) {
        return "redirect:/index.html";
    }

    @RequestMapping(value = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String viewCart(@RequestParam(name = "action", required = false) String action,
            @RequestParam(name = "itemName", required = false) String itemName,
            @RequestParam(name = "itemUUID", required = false) String itemUuid,
            Model model,
            HttpSession session) {

        // get sessionUser from session
        User sessionUser = getSessionUser(session);
        model.addAttribute("sessionUser", sessionUser);

        // used to set tab selected
        model.addAttribute("selectedPage", "home");

        String message = "";
        String errorMessage = "";

        // note that the shopping cart is is stored in the sessionUser's session
        // so there is one cart per sessionUser
        //ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        //if (shoppingCart == null) synchronized (this) {
        //  if (shoppingCart == null) {
        //    shoppingCart = WebObjectFactory.getNewShoppingCart();
        //  session.setAttribute("shoppingCart", shoppingCart);
        //}
        //}
        if (action == null) {
            // do nothing but show page
        } else if ("addItemToCart".equals(action)) {
            ShoppingItem shoppingItem = shoppingService.getItemByName(itemName);
            if (shoppingItem == null) {
                message = "cannot add " + itemName + " to cart";
            } else {
                message = "adding " + itemName + " to cart price = " + shoppingItem.getPrice();
                shoppingCart.addItemToCart(shoppingItem);
            }
        }

        if ("removeItemFromCart".equals(action)) {
            message = "removed " + itemName + " from cart";
            shoppingCart.removeItemFromCart(itemUuid);
        } else {
            message = "unknown action=" + action;
        }

        List<ShoppingItem> availableItems = shoppingService.getAvailableItems();

        System.out.println(availableItems);
        List<ShoppingItem> shoppingCartItems = shoppingCart.getShoppingCartItems();

        System.out.println(shoppingCartItems);

        Double shoppingcartTotal = shoppingCart.getTotal();

        // populate model with values
        model.addAttribute(
                "availableItems", availableItems);
        model.addAttribute(
                "shoppingCartItems", shoppingCartItems);
        model.addAttribute(
                "shoppingcartTotal", shoppingcartTotal);
        model.addAttribute(
                "message", message);
        model.addAttribute(
                "errorMessage", errorMessage);

        return "home";
    }

    @RequestMapping(value = "/about", method = {RequestMethod.GET, RequestMethod.POST})
    public String aboutCart(Model model, HttpSession session) {

        // get sessionUser from session
        User sessionUser = getSessionUser(session);
        model.addAttribute("sessionUser", sessionUser);

        // used to set tab selected
        model.addAttribute("selectedPage", "about");
        return "about";
    }

    @RequestMapping(value = "/contact", method = {RequestMethod.GET, RequestMethod.POST})
    public String contactCart(Model model, HttpSession session) {

        // get sessionUser from session
        User sessionUser = getSessionUser(session);
        model.addAttribute("sessionUser", sessionUser);

        // used to set tab selected
        model.addAttribute("selectedPage", "contact");
        return "contact";
    }

    @RequestMapping(value = "/catalog", method = {RequestMethod.GET, RequestMethod.POST})
    public String catalogCart(
            @RequestParam(name = "action", required = false) String action,
            @RequestParam(name = "itemName", required = false) String itemName,
            @RequestParam(name = "itemUUID", required = false) String itemUuid,
            @RequestParam(name = "stock", required = false) String stock,
            Model model, HttpSession session) {

        String message = "";
        String errorMessage = "";

        // get sessionUser from session
        User sessionUser = getSessionUser(session);
        model.addAttribute("sessionUser", sessionUser);
        System.out.println(action);
        if (action == null) {
            // do nothing but show page
        } else if ("changestock".equals(action)) {
            try {
                Integer stockInt = Integer.parseInt(stock);
                shoppingService.changeStock(itemName, stockInt);
            } catch (Exception ex) {
                errorMessage = "could not change name for stock stock=" + stock + " " + ex.toString();
            }

        }

        if ("append".equals(action)) {
            System.out.println("SADSDADASDDASDSA");

            shoppingService.NewAddItem("test");
        }

        List<ShoppingItem> availableItems = shoppingService.getAvailableItems();
        model.addAttribute("availableItems", availableItems);
        model.addAttribute("stock", stock);
        model.addAttribute("selectedPage", "catalog");
        model.addAttribute("message", message);
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("SelectedPage", "admin");
        return "catalog";
    }

    @RequestMapping(value = "/bank", method = {RequestMethod.GET, RequestMethod.POST})
    public String BankProperties(
            @RequestParam(name = "bankurl", required = false) String BankUrl,
            @RequestParam(name = "accname", required = false) String AccName,
            @RequestParam(name = "enddate", required = false) String EndDate,
            @RequestParam(name = "cardnumber", required = false) String CardNumber,
            @RequestParam(name = "cvv", required = false) String Cvv,
            @RequestParam(name = "issuenumber", required = false) String IssueNumber,
            @RequestParam(name = "action", required = false) String action,
            Model model, HttpSession session) {

        String message = "";
        String errorMessage = "";

        PropertiesDao propertiesDao = WebObjectFactory.getPropertiesDao();

        if (action == null) {
            message = "Please fill the fields if there is nothing to update the Bank Properties";
            String bankUrl = propertiesDao.getProperty("org.solent.com504.oodd.cart.web.url");
            String admin_username = propertiesDao.getProperty("org.solent.com504.oodd.cart.web.username");
            String admin_enddate = propertiesDao.getProperty("org.solent.com504.oodd.cart.web.enddate");
            String admin_cardnumber = propertiesDao.getProperty("org.solent.com504.oodd.cart.web.cardnumber");
            String admin_cvv = propertiesDao.getProperty("org.solent.com504.oodd.cart.web.cvv");
            String admin_issuenumber = propertiesDao.getProperty("org.solent.com504.oodd.cart.web.issuenumber");

            //      the name in the model,the variable
            model.addAttribute("bankUrl", bankUrl);
            model.addAttribute("admin_username", admin_username);
            model.addAttribute("admin_enddate", admin_enddate);
            model.addAttribute("admin_cardnumber", admin_cardnumber);
            model.addAttribute("admin_cvv", admin_cvv);
            model.addAttribute("admin_issuenumber", admin_issuenumber);
        } else if (action.equals("saveproperties")) {
            propertiesDao.setProperty("org.solent.com504.oodd.cart.web.url", BankUrl);
            propertiesDao.setProperty("org.solent.com504.oodd.cart.web.username", AccName);
            propertiesDao.setProperty("org.solent.com504.oodd.cart.web.enddate", EndDate);
            propertiesDao.setProperty("org.solent.com504.oodd.cart.web.cardnumber", CardNumber);
            propertiesDao.setProperty("org.solent.com504.oodd.cart.web.cvv", Cvv);
            propertiesDao.setProperty("org.solent.com504.oodd.cart.web.issuenumber", IssueNumber);
            message = "Successfully updated Bank Properties";
        } else {
            errorMessage = "Unknown action!";
        }

        // get sessionUser from session
        User sessionUser = getSessionUser(session);
        model.addAttribute("sessionUser", sessionUser);

        // used to set tab selected
        model.addAttribute("message", message);
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("selectedPage", "bank");
        model.addAttribute("BankUrl", BankUrl);

        return "bank";
    }

    @RequestMapping(value = "/checkout", method = {RequestMethod.GET, RequestMethod.POST})
    public String ChekoutPage(Model model, HttpSession session) {

        // get sessionUser from session
        User sessionUser = getSessionUser(session);
        model.addAttribute("sessionUser", sessionUser);

        // used to set tab selected
        model.addAttribute("selectedPage", "contact");
        return "checkout";
    }

    /*
     * Default exception handler, catches all exceptions, redirects to friendly
     * error page. Does not catch request mapping errors
     */
    @ExceptionHandler(Exception.class)
    public String myExceptionHandler(final Exception e, Model model, HttpServletRequest request) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        final String strStackTrace = sw.toString(); // stack trace as a string
        String urlStr = "not defined";
        if (request != null) {
            StringBuffer url = request.getRequestURL();
            urlStr = url.toString();
        }
        model.addAttribute("requestUrl", urlStr);
        model.addAttribute("strStackTrace", strStackTrace);
        model.addAttribute("exception", e);
        //logger.error(strStackTrace); // send to logger first
        return "error"; // default friendly exception message for sessionUser
    }

}
