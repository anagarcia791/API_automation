package util.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.github.javafaker.Faker;
import model.BankUserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class WorkFlow {

    /**
     * Get all date set method.
     *
     * @param res      : parameter of type http response
     * @param jsonPath : parameter of type json path
     * @return : all data as list of BankUserModel object
     */
    public List<BankUserModel> getAllDataSet(Response res, JsonPath jsonPath) {
        res = RestAssuredUtil.getResponse();
        jsonPath = res.jsonPath();
        return jsonPath.getList("", BankUserModel.class);
    }

    /**
     * Get specific bank user.
     *
     * @param res : parameter of type http response
     * @return : specific bank user of BankUserModel object
     */
    public BankUserModel getBankUser(Response res, String userId) {
        res = RestAssuredUtil.getResponse(userId);
        return res.as(BankUserModel.class);
    }

    /**
     * Get data set ids.
     *
     * @param bankUsersData : List of bankUsersData
     * @return : list of users id
     */
    public List<String> getDataIds(List<BankUserModel> bankUsersData) {
        List<String> ids = new ArrayList<>();

        if (bankUsersData.size() > 0) {
            for (BankUserModel userBank : bankUsersData) {
                ids.add(userBank.getId());
            }
        }

        return ids;
    }

    /**
     * Creates with random data a new BankUserModel object.
     *
     * @return : BankUserModel object
     */
    public BankUserModel bankUserCreation() {
        Faker dataFaker = Faker.instance(new Locale("en-US"));
        return new BankUserModel(
                dataFaker.name().name(),
                dataFaker.name().lastName(),
                String.valueOf(dataFaker.number().numberBetween(0, 10000)),
                String.valueOf(dataFaker.number().randomDouble(2, 0, 10000)),
                dataFaker.options().option("withdrawal", "payment", "invoice", "deposit"),
                dataFaker.internet().emailAddress(),
                String.valueOf(dataFaker.random().nextBoolean()),
                dataFaker.country().name(),
                dataFaker.phoneNumber().cellPhone(),
                "");
    }

    /**
     * Creates a list of BankUserModel objects.
     *
     * @param amountOfNewUsers : size list desired
     * @return : list of BankUserModel objects
     */
    public List<BankUserModel> bankUserListCreation(int amountOfNewUsers) {

        List<BankUserModel> newUsersList = new ArrayList<>();

        do {
            BankUserModel userToAdd = bankUserCreation();

            List<BankUserModel> duplicateData =
                    newUsersList.stream()
                            .filter(user -> user.getEmail().equalsIgnoreCase(userToAdd.getEmail()))
                            .collect(Collectors.toList());

            if (duplicateData.size() == 0) {
                newUsersList.add(userToAdd);
            }
        }
        while (newUsersList.size() < amountOfNewUsers);

        return newUsersList;
    }

    /**
     * Return a list of BankUserModel objects.
     *
     * @param res      : parameter of type http response
     * @param jsonPath : parameter of type json path
     * @return : data as list of BankUserModel object
     */
    public List<BankUserModel> createNewUserIfDataSetEmpty(Response res, JsonPath jsonPath) {

        List<BankUserModel> bankUsersData = getAllDataSet(res, jsonPath);

        if (bankUsersData.size() == 0) {
            RestAssuredUtil.postResponse(bankUserCreation());
        }

        return getAllDataSet(res, jsonPath);
    }

    /**
     * Get object updated.
     *
     * @param res        : parameter of type http response
     * @param idToUpdate : user id to update
     * @return : BankUserModel object
     */
    public BankUserModel getUserObjectUpdated(Response res, String idToUpdate, String newAccountNumber) {
        BankUserModel bankUser = getBankUser(res, idToUpdate);
        bankUser.setAccountNumber(newAccountNumber);
        return bankUser;
    }

}
