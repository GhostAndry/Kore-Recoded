#!/bin/bash

# Configura Git per usare il credential helper cache con timeout di 30 giorni
git config --global credential.helper 'cache --timeout=2592000'

# Funzione per impostare il token di accesso
set_git_credentials() {
    read -p "Inserisci il tuo Git username: " username
    read -sp "Inserisci il tuo access token: " token
    echo

    # Crea una URL remota con il token incluso
    repo_url=$(git remote get-url origin)
    repo_url_with_token=$(echo "$repo_url" | sed -e "s|https://|https://$username:$token@|g")

    # Memorizza temporaneamente le credenziali
    git credential-cache store <<<"protocol=https
host=$(echo "$repo_url" | awk -F/ '{print $3}')
username=$username
password=$token"
    
    echo "Credenziali memorizzate per 30 giorni."
}

# Esegui la funzione per impostare le credenziali
set_git_credentials
