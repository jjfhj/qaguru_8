package com.github.jjfhj;

public enum ProfileMenu {
    SIGNIN("Войти"),
    ORDERS("Заказы"),
    FAVORITES("Избранное"),
    CART("Корзина");

    private String profileMenu;

    ProfileMenu(String profileMenu) {
        this.profileMenu = profileMenu;
    }

    public String getProfileMenu() {
        return profileMenu;
    }

    @Override
    public String toString() {
        return profileMenu;
    }
}
