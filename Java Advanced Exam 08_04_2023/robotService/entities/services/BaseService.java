package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BaseService implements Service {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        if (this.robots.size() >= this.capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }

        this.robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot : this.robots) {
            robot.eating();
        }
    }

    @Override
    public int sumHardness() {
        int hardnessSum = 0;

        for (Supplement supplement : supplements) {
            hardnessSum += supplement.getHardness();
        }

        return hardnessSum;
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s %s:\nRobots: ", getName(), getClass().getSimpleName()));

        if (getRobots().size() < 1) {
            stringBuilder.append("none");
        } else {
            for (Robot robot : robots) {
                stringBuilder.append(robot.getName()).append(" ");
            }
        }

        stringBuilder.append(String.format("\nSupplements: %d Hardness: %d", supplements.size(), sumHardness()));

        return String.valueOf(stringBuilder);
    }
}
