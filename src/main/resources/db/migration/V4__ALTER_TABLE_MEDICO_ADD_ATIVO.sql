ALTER TABLE medico ADD ativo BOOLEAN;
UPDATE medico SET ativo = true;
ALTER TABLE medico ALTER COLUMN ativo SET NOT NULL;