import javax.xml.transform.stax.StAXResult;

// Представьте, что вы пишете класс Reder, который отвечает за вывод на экран текущего уровня жизней и усталости какого-то объекта.
// (Подразумеваем, что вывод на экран - это просто печать в консоль)
// У класса есть 1 метод, который принимает тип Object и делает следующее:
// 1. Если object типа HasHealthPoint, то выводим его уровень жизни
// 2. Если object типа Tiredness, то выводим его уровень усталости
// При этом текст значения должен иметь цвет в соответствии с правилом:
// BLACK(0, 24), RED(25, 50), GREEN(51-100)
// 3. Создать несколько классов:
// 3.1 Здание. Имеет только жизни.
// 3.2 Персноаж. Имеет и жизни, и усталость

public class Main
{
    public static void main(String[] args)
    {
        Building building = new Building(100, 50);

        Render render = new Render();
        render.render(building);
    }

    static class Render
    {
        public void render(Object object)
        {

        }
    }

    static class HealthPointViewer
    {
        public void viewHealthPoint(HasHealthPoint hasHealthPoint)
        {
            System.out.println(hasHealthPoint.getCurrentHealthPoint());
        }
    }

    static class ViewTiredness
    {
        public void viewTiredness(Tiredness tiredness)
        {
            System.out.println(tiredness.getCurrentEnergyPoint());
        }
    }

    interface HasHealthPoint
    {
        int getMaxHealthPoint();
        int getCurrentHealthPoint();
    }

    interface Tiredness
    {
        int getMaxEnergyPoint();
        int getCurrentEnergyPoint();
    }

    static class Building implements HasHealthPoint
    {
        private int maxHealthPoint;
        private int currentHealthPoint;

        public Building(int maxHealthPoint, int currentHealthPoint)
        {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = currentHealthPoint;
        }

        @Override
        public int getMaxHealthPoint()
        {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealthPoint()
        {
            return currentHealthPoint;
        }
    }

    static class Hero implements HasHealthPoint, Tiredness
    {
        private int maxHealthPoint;
        private int currentHealthPoint;
        private int maxEnergyPoint;
        private int currentEnergyPoint;

        public Hero(int maxHealthPoint, int currentHealthPoint, int maxEnergyPoint, int currentEnergyPoint)
        {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = currentHealthPoint;
            this.maxEnergyPoint = maxEnergyPoint;
            this.currentEnergyPoint = currentEnergyPoint;
        }

        @Override
        public int getMaxHealthPoint()
        {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealthPoint()
        {
            return currentHealthPoint;
        }

        @Override
        public int getMaxEnergyPoint()
        {
            return maxEnergyPoint;
        }

        @Override
        public int getCurrentEnergyPoint()
        {
            return currentEnergyPoint;
        }
    }
}
