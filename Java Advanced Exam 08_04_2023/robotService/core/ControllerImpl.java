package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements = new SupplementRepository();
    private Collection<Service> services = new ArrayList<>();

    @Override
    public String addService(String type, String name) {
        Service service;

        switch (type) {
            case "MainService":
                service = new MainService(name);
                break;
            case "SecondaryService":
                service = new SecondaryService(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }

        this.services.add(service);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;

        switch (type) {
            case "PlasticArmor":
                supplement = new PlasticArmor();
                break;
            case "MetalArmor":
                supplement = new MetalArmor();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        this.supplements.addSupplement(supplement);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement foundSupplement = supplements.findFirst(supplementType);

        if (foundSupplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                service.addSupplement(foundSupplement);
                supplements.removeSupplement(foundSupplement);
            }
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot = null;

        switch (robotType) {
            case "FemaleRobot":
                robot = new FemaleRobot(robotName, robotKind, price);
                break;
            case "MaleRobot":
                robot = new MaleRobot(robotName, robotKind, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }

        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                switch (robotType) {
                    case "FemaleRobot":
                        if (service.getClass().getSimpleName().equals("MainService")) {
                            return "Unsuitable service.";
                        }

                        service.addRobot(robot);
                        break;
                    case "MaleRobot":
                        if (service.getClass().getSimpleName().equals("SecondaryService")) {
                            return "Unsuitable service.";
                        }

                        service.addRobot(robot);
                        break;
                }
            }
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        int fedRobots = 0;

        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                service.feeding();

                fedRobots += service.getRobots().size();
            }
        }

        return String.format(ConstantMessages.FEEDING_ROBOT, fedRobots);
    }

    @Override
    public String sumOfAll(String serviceName) {
        double sum = 0;
        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                Collection<Robot> robots = service.getRobots();

                for (Robot robot : robots) {
                    sum += robot.getPrice();
                }

                Collection<Supplement> supplements = service.getSupplements();

                for (Supplement supplement : supplements) {
                    sum += supplement.getPrice();
                }
            }
        }

        return String.format(ConstantMessages.VALUE_SERVICE, serviceName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Service service : services) {
            stringBuilder.append(String.format("%s\n", service.getStatistics()));
        }

        return String.valueOf(stringBuilder);
    }
}
